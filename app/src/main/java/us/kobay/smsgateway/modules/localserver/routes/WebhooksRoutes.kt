package us.kobay.smsgateway.modules.localserver.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import us.kobay.smsgateway.domain.EntitySource
import us.kobay.smsgateway.modules.webhooks.WebHooksService
import us.kobay.smsgateway.modules.webhooks.domain.WebHookDTO

class WebhooksRoutes(
    private val webHooksService: WebHooksService,
) {
    fun register(routing: Route) {
        routing.apply {
            webhooksRoutes()
        }
    }

    private fun Route.webhooksRoutes() {
        get {
            call.respond(webHooksService.select(EntitySource.Local))
        }
        post {
            val webhook = call.receive<WebHookDTO>()
            val updated = webHooksService.replace(EntitySource.Local, webhook)

            call.respond(HttpStatusCode.Created, updated)
        }
        delete("/{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            webHooksService.delete(EntitySource.Local, id)
            call.respond(HttpStatusCode.NoContent)
        }
    }
}