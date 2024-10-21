package us.kobay.smsgateway.modules.receiver.events

import us.kobay.smsgateway.modules.events.AppEvent
import java.util.Date

class MessageReceivedEvent(
    val message: String,
    val phoneNumber: String,
    val receivedAt: Date,
) : AppEvent(
    name = NAME
) {
    companion object {
        const val NAME = "MessageReceivedEvent"
    }
}
