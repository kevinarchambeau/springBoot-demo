package com.ka.spring_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDemoApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/hello")
	fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
		return "Hello $name"
	}
}


