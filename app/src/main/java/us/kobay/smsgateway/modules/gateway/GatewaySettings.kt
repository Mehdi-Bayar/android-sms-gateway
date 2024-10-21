package us.kobay.smsgateway.modules.gateway

import us.kobay.smsgateway.modules.settings.KeyValueStorage
import us.kobay.smsgateway.modules.settings.get

class GatewaySettings(
    private val storage: KeyValueStorage,
) {
    var enabled: Boolean
        get() = storage.get<Boolean>(ENABLED) ?: false
        set(value) = storage.set(ENABLED, value)

    val deviceId: String?
        get() = registrationInfo?.id

    var registrationInfo: GatewayApi.DeviceRegisterResponse?
        get() = storage.get(REGISTRATION_INFO)
        set(value) = storage.set(REGISTRATION_INFO, value)

    val privateUrl: String?
        get() = storage.get<String?>(CLOUD_URL)
    val privateToken: String?
        get() = storage.get<String>(PRIVATE_TOKEN)

    companion object {
        private const val REGISTRATION_INFO = "REGISTRATION_INFO"
        private const val ENABLED = "ENABLED"

        private const val CLOUD_URL = "cloud_url"
        private const val PRIVATE_TOKEN = "private_token"

        const val PUBLIC_URL = "https://api.sms-gate.app/mobile/v1"
    }
}