package us.kobay.smsgateway.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MessageWithRecipients(
    @Embedded val message: Message,
    @Relation(
        parentColumn = "id",
        entityColumn = "messageId",
    )
    val recipients: List<MessageRecipient>,
    @Relation(
        parentColumn = "id",
        entityColumn = "messageId",
    )
    val states: List<MessageState> = emptyList()
) {
    val state: us.kobay.smsgateway.domain.ProcessingState
        get() = when {
            recipients.any { it.state == us.kobay.smsgateway.domain.ProcessingState.Pending } -> us.kobay.smsgateway.domain.ProcessingState.Pending
            recipients.any { it.state == us.kobay.smsgateway.domain.ProcessingState.Processed } -> us.kobay.smsgateway.domain.ProcessingState.Processed

            recipients.all { it.state == us.kobay.smsgateway.domain.ProcessingState.Failed } -> us.kobay.smsgateway.domain.ProcessingState.Failed
            recipients.all { it.state == us.kobay.smsgateway.domain.ProcessingState.Delivered } -> us.kobay.smsgateway.domain.ProcessingState.Delivered
            else -> us.kobay.smsgateway.domain.ProcessingState.Sent
        }
}
