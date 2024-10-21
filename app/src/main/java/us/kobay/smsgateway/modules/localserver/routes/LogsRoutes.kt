package us.kobay.smsgateway.modules.localserver.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import us.kobay.smsgateway.helpers.DateHelper
import us.kobay.smsgateway.modules.localserver.domain.GetLogsResponse
import us.kobay.smsgateway.modules.logs.LogsService
import java.time.Instant

class LogsRoutes(
    private val logsService: LogsService,
) {

    fun register(routing: Route) {
        routing.apply {
            logsRoutes()
        }
    }

    private fun Route.logsRoutes() {
        get {
            try {
                val from = call.request.queryParameters["from"]?.let {
                    DateHelper.ISO_DATE_TIME.parse(it)
                }?.let { Instant.from(it).toEpochMilli() }
                val to = call.request.queryParameters["to"]?.let {
                    DateHelper.ISO_DATE_TIME.parse(it)
                }?.let { Instant.from(it).toEpochMilli() }

                call.respond(logsService.select(from, to).map { GetLogsResponse.from(it) })
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, mapOf("message" to e.message))
                return@get
            }
        }
    }
}