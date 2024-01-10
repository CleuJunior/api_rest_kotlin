package br.com.cleonildo.dto

import br.com.cleonildo.model.Gender

data class PersonRequest(
    val firstName: String,
    val lastName: String,
    val address: String,
    val gender: Gender
)