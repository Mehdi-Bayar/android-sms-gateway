package us.kobay.smsgateway

import android.app.Application
import healthModule
import us.kobay.smsgateway.data.dbModule
import us.kobay.smsgateway.helpers.SettingsHelper
import us.kobay.smsgateway.modules.encryption.encryptionModule
import us.kobay.smsgateway.modules.events.eventBusModule
import us.kobay.smsgateway.modules.gateway.GatewayService
import us.kobay.smsgateway.modules.localserver.localserverModule
import us.kobay.smsgateway.modules.logs.logsModule
import us.kobay.smsgateway.modules.messages.messagesModule
import us.kobay.smsgateway.modules.notifications.notificationsModule
import us.kobay.smsgateway.modules.orchestrator.OrchestratorService
import us.kobay.smsgateway.modules.orchestrator.orchestratorModule
import us.kobay.smsgateway.modules.ping.pingModule
import us.kobay.smsgateway.modules.settings.settingsModule
import us.kobay.smsgateway.modules.webhooks.webhooksModule
import us.kobay.smsgateway.receivers.EventsReceiver
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                eventBusModule,
                settingsModule,
                dbModule,
                logsModule,
                notificationsModule,
                messagesModule,
                encryptionModule,
                us.kobay.smsgateway.modules.gateway.gatewayModule,
                healthModule,
                webhooksModule,
                localserverModule,
                pingModule,
                orchestratorModule,
            )
        }

        instance = this

        EventsReceiver.register(this)

        if (SettingsHelper(this).autostart) {
            get<OrchestratorService>().start(this)
        }
    }

    val gatewayService: GatewayService by inject()

    companion object {
        lateinit var instance: App
            private set
    }
}