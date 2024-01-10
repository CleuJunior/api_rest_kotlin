package br.com.cleonildo.dto

data class PersonRequest(
    val firstName: String,
    val lastName: String,
    val address: String,
    val gender: String
)