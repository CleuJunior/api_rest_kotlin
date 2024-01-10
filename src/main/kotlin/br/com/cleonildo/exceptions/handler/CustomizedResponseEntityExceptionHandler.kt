package br.com.cleonildo.exceptions.handler

import br.com.cleonildo.exceptions.ExceptionResponse
import br.com.cleonildo.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(exception: ResourceNotFoundException) : ResponseEntity<ExceptionResponse> {

        val response = ExceptionResponse(
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.reasonPhrase,
            exception.message,
            LocalDateTime.now()
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }
}