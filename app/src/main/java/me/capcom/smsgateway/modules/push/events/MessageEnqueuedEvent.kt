package me.capcom.smsgateway.modules.push.events

import me.capcom.smsgateway.modules.events.AppEvent

class MessageEnqueuedEvent : AppEvent(NAME) {
    companion object {
        private const val NAME = "MessageEnqueuedEvent"
    }
}