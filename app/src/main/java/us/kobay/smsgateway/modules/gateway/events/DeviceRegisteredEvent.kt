package us.kobay.smsgateway.modules.gateway.events

import us.kobay.smsgateway.modules.events.AppEvent

class DeviceRegisteredEvent(
    val server: String,
    val login: String,
    val password: String,
): AppEvent(NAME) {
    companion object {
        const val NAME = "DeviceRegisteredEvent"
    }
}