package us.kobay.smsgateway.modules.webhooks.domain

data class WebHookDTO(
    val id: String?,
    val url: String,
    val event: WebHookEvent,
)
