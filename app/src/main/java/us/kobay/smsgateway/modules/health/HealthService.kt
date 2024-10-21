package us.kobay.smsgateway.modules.health

import us.kobay.smsgateway.modules.health.domain.HealthResult
import us.kobay.smsgateway.modules.health.domain.Status
import us.kobay.smsgateway.modules.messages.MessagesService

class HealthService(
    private val messagesSvc: MessagesService,
) {

    fun healthCheck(): HealthResult {
        val messagesChecks = messagesSvc.healthCheck()
        val allChecks = messagesChecks.mapKeys { "messages:${it.key}" }

        return HealthResult(
            when {
                allChecks.values.any { it.status == Status.FAIL } -> Status.FAIL
                allChecks.values.any { it.status == Status.WARN } -> Status.WARN
                else -> Status.PASS
            },
            allChecks
        )
    }
}