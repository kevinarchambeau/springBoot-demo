package com.ka.spring_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDemoApplication>(*args)
}

@RestController
class MessageController(val service: MessageService) {

	@PostMapping("/message")
	fun postMessage(@RequestBody message: Message) {
		service.writeMessage(message)
		ResponseEntity.ok("Message created")
	}

	@GetMapping("/messages")
	fun messages(): List<Message> = service.getMessages()

	@GetMapping("/message/{id}")
	fun getMessage(@PathVariable id: String): List<Message> = service.getMessage(id)

	@DeleteMapping("/message/{id}")
	fun deleteMessage(@PathVariable id: String) {
		service.deleteMessage(id)
		ResponseEntity.ok("Message deleted")
	}

}



