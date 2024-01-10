package br.com.cleonildo.controller

import br.com.cleonildo.dto.PersonRequest
import br.com.cleonildo.dto.PersonResponse
import br.com.cleonildo.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/people")
class PersonController(private val service: PersonService) {


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): ResponseEntity<List<PersonResponse>> {
        val body: List<PersonResponse> = this.service.findAll()
        return ResponseEntity.ok(body)
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value="id") id: Long): ResponseEntity<PersonResponse> {
        val body: PersonResponse = this.service.findById(id)
        return ResponseEntity.ok(body)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody request: PersonRequest): ResponseEntity<PersonResponse> {
        val body: PersonResponse = this.service.create(request)

        return ResponseEntity.status(HttpStatus.CREATED).body(body)
    }

    @PutMapping(
        value = ["/{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@PathVariable(value = "id") id: Long, @RequestBody request: PersonRequest):
            ResponseEntity<PersonResponse> {

        val body: PersonResponse = this.service.update(id, request)
        return ResponseEntity.ok(body)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value="id") id: Long) : ResponseEntity<Unit> {
        this.service.delete(id)
        return ResponseEntity.noContent().build()
    }
}