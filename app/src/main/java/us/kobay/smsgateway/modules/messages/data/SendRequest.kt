package us.kobay.smsgateway.modules.messages.data

import us.kobay.smsgateway.domain.EntitySource

data class SendRequest(
    val source: EntitySource,
    val message: Message,
    val params: SendParams,
)