package com.yourname.messenger

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Message(val id: String, val text: String, val isMe: Boolean, val timestamp: Long = System.currentTimeMillis())

class ChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText.asStateFlow()

    fun sendMessage() {
        val text = _inputText.value.trim()
        if (text.isEmpty()) return
        _messages.value += Message(id = System.currentTimeMillis().toString(), text = text, isMe = true)
        _inputText.value = ""
        // TODO: Здесь подключается WebSocket/REST отправка на сервер
    }

    fun updateInput(text: String) { _inputText.value = text }
}
