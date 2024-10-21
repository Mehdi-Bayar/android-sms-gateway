package us.kobay.smsgateway.modules.push

import com.google.gson.annotations.SerializedName

enum class Event {
    @SerializedName("MessageEnqueued")
    MessageEnqueued,

    @SerializedName("WebhooksUpdated")
    WebhooksUpdated,
}