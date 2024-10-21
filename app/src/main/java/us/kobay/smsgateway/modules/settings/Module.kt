package us.kobay.smsgateway.modules.settings

import androidx.preference.PreferenceManager
import us.kobay.smsgateway.helpers.SettingsHelper
import us.kobay.smsgateway.modules.encryption.EncryptionSettings
import us.kobay.smsgateway.modules.gateway.GatewaySettings
import us.kobay.smsgateway.modules.localserver.LocalServerSettings
import us.kobay.smsgateway.modules.logs.LogsSettings
import us.kobay.smsgateway.modules.messages.MessagesSettings
import us.kobay.smsgateway.modules.ping.PingSettings
import us.kobay.smsgateway.modules.webhooks.WebhooksSettings
import org.koin.dsl.module

val settingsModule = module {
    factory { PreferenceManager.getDefaultSharedPreferences(get()) }
    factory { SettingsHelper(get()) }
    factory {
        EncryptionSettings(
            PreferencesStorage(get(), "encryption")
        )
    }
    factory {
        GatewaySettings(
            PreferencesStorage(get(), "gateway")
        )
    }
    factory {
        MessagesSettings(
            PreferencesStorage(get(), "messages")
        )
    }
    factory {
        LocalServerSettings(
            PreferencesStorage(get(), "localserver")
        )
    }
    factory {
        PingSettings(
            PreferencesStorage(get(), "ping")
        )
    }
    factory {
        LogsSettings(
            PreferencesStorage(get(), "logs")
        )
    }
    factory {
        WebhooksSettings(
            PreferencesStorage(get(), "webhooks")
        )
    }
}