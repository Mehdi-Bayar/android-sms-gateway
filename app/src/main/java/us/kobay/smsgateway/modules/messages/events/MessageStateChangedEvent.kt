package us.kobay.smsgateway.modules.messages.events

import us.kobay.smsgateway.domain.EntitySource
import us.kobay.smsgateway.domain.ProcessingState
import us.kobay.smsgateway.modules.events.AppEvent

class MessageStateChangedEvent(
    val id: String,
    val source: EntitySource,
    val phoneNumbers: Set<String>,
    val state: ProcessingState,
    val error: String?
): AppEvent(NAME) {

    companion object {
        const val NAME = "MessageStateChangedEvent"
    }
}