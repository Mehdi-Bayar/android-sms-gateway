package us.kobay.smsgateway.modules.messages.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import us.kobay.smsgateway.data.entities.Message
import us.kobay.smsgateway.modules.messages.repositories.MessagesRepository

class MessagesListViewModel(
    messagesRepo: MessagesRepository
) : ViewModel() {
    val messages: LiveData<List<Message>> =
        messagesRepo.lastMessages
}