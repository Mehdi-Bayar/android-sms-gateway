package us.kobay.smsgateway.modules.messages.repositories

import androidx.lifecycle.distinctUntilChanged
import us.kobay.smsgateway.data.dao.MessagesDao

class MessagesRepository(private val dao: MessagesDao) {
    val lastMessages = dao.selectLast().distinctUntilChanged()

    fun selectPending() = dao.selectPending()
    fun get(id: String) = dao.get(id)
}