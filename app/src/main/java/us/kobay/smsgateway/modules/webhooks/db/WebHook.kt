package us.kobay.smsgateway.modules.webhooks.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import us.kobay.smsgateway.domain.EntitySource
import us.kobay.smsgateway.modules.webhooks.domain.WebHookEvent

@Entity
data class WebHook(
    @PrimaryKey
    val id: String,
    val url: String,
    val event: WebHookEvent,
    val source: EntitySource,
)