package us.kobay.smsgateway.modules.push.events

import us.kobay.smsgateway.modules.events.AppEvent

class PushMessageEnqueuedEvent : AppEvent(NAME) {
    companion object {
        private const val NAME = "MessageEnqueuedEvent"
    }
}