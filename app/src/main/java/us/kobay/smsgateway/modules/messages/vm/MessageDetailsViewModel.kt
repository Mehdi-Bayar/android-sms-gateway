package us.kobay.smsgateway.modules.messages.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import us.kobay.smsgateway.data.entities.MessageWithRecipients
import us.kobay.smsgateway.modules.messages.repositories.MessagesRepository

class MessageDetailsViewModel(
    private val messagesRepo: MessagesRepository
) : ViewModel() {
    private val _message = MutableLiveData<MessageWithRecipients>()
    val message: LiveData<MessageWithRecipients> = _message

    fun get(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _message.postValue(messagesRepo.get(id))
        }
    }
}