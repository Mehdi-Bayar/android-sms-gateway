package us.kobay.smsgateway.modules.orchestrator

import android.content.Context
import us.kobay.smsgateway.modules.gateway.GatewayService
import us.kobay.smsgateway.modules.localserver.LocalServerService
import us.kobay.smsgateway.modules.logs.LogsService
import us.kobay.smsgateway.modules.messages.MessagesService
import us.kobay.smsgateway.modules.ping.PingService
import us.kobay.smsgateway.modules.webhooks.WebHooksService

class OrchestratorService(
    private val messagesSvc: MessagesService,
    private val gatewaySvc: GatewayService,
    private val localServerSvc: LocalServerService,
    private val webHooksSvc: WebHooksService,
    private val pingSvc: PingService,
    private val logsSvc: LogsService,
) {
    fun start(context: Context) {
        logsSvc.start(context)
        messagesSvc.start(context)
        gatewaySvc.start(context)
        localServerSvc.start(context)
        webHooksSvc.start(context)
        pingSvc.start(context)
    }

    fun stop(context: Context) {
        pingSvc.stop(context)
        webHooksSvc.stop(context)
        localServerSvc.stop(context)
        gatewaySvc.stop(context)
        messagesSvc.stop(context)
        logsSvc.stop(context)
    }
}