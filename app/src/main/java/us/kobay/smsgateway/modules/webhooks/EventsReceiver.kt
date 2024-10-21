package us.kobay.smsgateway.modules.webhooks

import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import us.kobay.smsgateway.domain.ProcessingState
import us.kobay.smsgateway.modules.events.EventBus
import us.kobay.smsgateway.modules.events.EventsReceiver
import us.kobay.smsgateway.modules.messages.events.MessageStateChangedEvent
import us.kobay.smsgateway.modules.ping.events.PingEvent
import us.kobay.smsgateway.modules.webhooks.domain.WebHookEvent
import us.kobay.smsgateway.modules.webhooks.payload.SmsEventPayload
import org.koin.core.component.get
import java.util.Date

class EventsReceiver : EventsReceiver() {
    override suspend fun collect(eventBus: EventBus) {
        coroutineScope {
            launch {
                eventBus.collect<PingEvent> {
                    Log.d("EventsReceiver", "Event: $it")

                    get<WebHooksService>().emit(WebHookEvent.SystemPing, object {})
                }
            }

            launch {
                eventBus.collect<MessageStateChangedEvent> { event ->
                    Log.d("EventsReceiver", "Event: $event")

                    val webhookEventType = when (event.state) {
                        ProcessingState.Sent -> WebHookEvent.SmsSent
                        ProcessingState.Delivered -> WebHookEvent.SmsDelivered
                        ProcessingState.Failed -> WebHookEvent.SmsFailed
                        else -> return@collect
                    }

                    event.phoneNumbers.forEach { phoneNumber ->
                        val payload = when (webhookEventType) {
                            WebHookEvent.SmsSent -> SmsEventPayload.SmsSent(
                                messageId = event.id,
                                phoneNumber = phoneNumber,
                                sentAt = Date(),
                            )

                            WebHookEvent.SmsDelivered -> SmsEventPayload.SmsDelivered(
                                messageId = event.id,
                                phoneNumber = phoneNumber,
                                deliveredAt = Date(),
                            )

                            WebHookEvent.SmsFailed -> SmsEventPayload.SmsFailed(
                                messageId = event.id,
                                phoneNumber = phoneNumber,
                                failedAt = Date(),
                                reason = event.error ?: "Unknown",
                            )

                            else -> return@forEach
                        }

                        get<WebHooksService>().emit(
                            webhookEventType, payload
                        )
                    }
                }
            }
        }
    }
}