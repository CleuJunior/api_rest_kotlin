package br.com.cleonildo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestApiKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestApiKotlinApplication>(*args)
}
