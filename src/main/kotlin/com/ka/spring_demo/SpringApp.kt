package com.ka.spring_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDemoApplication>(*args)
}

@RestController
class MessageController(val service: MessageService) {
	@GetMapping("/messages")
	fun messages(): List<Message> = service.getMessages()

	@GetMapping("/message/{id}")
	fun getMessage(@PathVariable id: String): List<Message> = service.getMessage(id)

	@PostMapping("/message")
	fun postMessage(@RequestBody message: Message): String {
		service.writeMessage(message)
		return "Message saved"
	}
}



