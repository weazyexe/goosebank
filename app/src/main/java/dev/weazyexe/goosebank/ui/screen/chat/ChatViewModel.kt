package dev.weazyexe.goosebank.ui.screen.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.weazyexe.goosebank.domain.Message
import dev.weazyexe.goosebank.repository.MessagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * [ChatFragment]'s view model
 */
class ChatViewModel : ViewModel() {

    private val messagesRepository = MessagesRepository()

    private val _messages = MutableStateFlow(listOf<Message>())
    val messages = _messages.asStateFlow()

    fun loadMessages() = viewModelScope.launch {
        _messages.emit(messagesRepository.getMessages())
    }
}