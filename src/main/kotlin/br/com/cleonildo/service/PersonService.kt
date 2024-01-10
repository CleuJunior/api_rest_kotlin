package br.com.cleonildo.service

import br.com.cleonildo.dto.PersonRequest
import br.com.cleonildo.dto.PersonResponse
import br.com.cleonildo.model.Person
import br.com.cleonildo.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.logging.Logger

private const val idNotFound = "No records found for this ID!"

@Service
@Transactional
class PersonService(private val repository: PersonRepository) {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    @Transactional(readOnly = true)
    fun findAll(): List<PersonResponse> {
        logger.info("Finding all people!")

        val persons = repository.findAll()
            .stream()
            .map(::PersonResponse)
            .toList()

        return persons
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): PersonResponse {
        logger.info("Finding one person!")

        val person: Person = repository.findById(id)
            .orElseThrow { RuntimeException(idNotFound) }

        return PersonResponse(person);
    }

    fun create(request: PersonRequest) : PersonResponse {
        logger.info("Creating one person with name ${request.firstName}!")
        val person: Person = this.toPersonEntity(request)

        return PersonResponse(this.repository.save(person))
    }

    private fun toPersonEntity(request: PersonRequest) =
        Person(request.firstName, request.lastName,  request.address, request.gender)

    fun update(id: Long, request: PersonRequest) : PersonResponse {
        logger.info("Updating one person with ID ${id}!")

        val person: Person = repository.findById(id)
            .orElseThrow { RuntimeException(idNotFound) }

        person.firstName = request.firstName
        person.lastName = request.lastName
        person.address = request.address
        person.gender = request.gender

        return PersonResponse(repository.save(person))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { RuntimeException(idNotFound) }
        repository.delete(entity)
    }
}