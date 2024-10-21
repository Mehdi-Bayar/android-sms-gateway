package us.kobay.smsgateway.modules.localserver

import us.kobay.smsgateway.modules.settings.KeyValueStorage
import us.kobay.smsgateway.modules.settings.get

class LocalServerSettings(
    private val storage: KeyValueStorage,
) {
    var enabled: Boolean
        get() = storage.get<Boolean>(ENABLED) ?: false
        set(value) = storage.set(ENABLED, value)

    var deviceId: String?
        get() = storage.get<String?>(DEVICE_ID)
        set(value) = storage.set(DEVICE_ID, value)

    companion object {
        private const val ENABLED = "ENABLED"

        private const val DEVICE_ID = "DEVICE_ID"
    }
}