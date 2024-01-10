package br.com.cleonildo.dto

import br.com.cleonildo.model.Person

data class PersonResponse(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val address: String,
    val gender: String
) {
    constructor(person: Person) : this(
        person.id,
        person.firstName,
        person.lastName,
        person.address,
        person.gender,
    )
}