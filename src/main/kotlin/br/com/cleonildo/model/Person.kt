package br.com.cleonildo.model

import jakarta.persistence.*


@Entity
@Table(name = "person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(nullable = false, length = 6)
    var gender: String = ""
) {

    constructor(
        firstName: String,
        lastName: String,
        address: String,
        gender: String
    ) : this(null, firstName, lastName, address, gender)
}