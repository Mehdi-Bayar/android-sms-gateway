package us.kobay.smsgateway.modules.ping.events

import us.kobay.smsgateway.modules.events.AppEvent

class PingEvent : AppEvent(TYPE) {
    companion object {
        const val TYPE = "PingEvent"
    }
}