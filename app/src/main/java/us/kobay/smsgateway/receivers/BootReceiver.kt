package us.kobay.smsgateway.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import us.kobay.smsgateway.helpers.SettingsHelper
import us.kobay.smsgateway.modules.orchestrator.OrchestratorService
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class BootReceiver : BroadcastReceiver(), KoinComponent {

    override fun onReceive(context: Context, intent: Intent) {
        if (!events.contains(intent.action)) return

        if (SettingsHelper(context).autostart) {
            get<OrchestratorService>().start(context)
        }
    }

    companion object {
        private val events = setOf(
            Intent.ACTION_BOOT_COMPLETED,
            "android.intent.action.ACTION_BOOT_COMPLETED",
            Intent.ACTION_REBOOT,
            "android.intent.action.QUICKBOOT_POWERON",
            "com.htc.intent.action.QUICKBOOT_POWERON",
            Intent.ACTION_SHUTDOWN,
        )
    }
}