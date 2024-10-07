package com.ka.spring_demo

import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db: MessageRepository) {
    fun getMessages(): List<Message> = db.findAll().toList()

    fun writeMessage(message: Message) {
        db.save(message)
    }

    fun getMessage(id: String): List<Message> = db.findById(id).toList()

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}