package br.com.cleonildo.model

import br.com.cleonildo.dto.PersonRequest
import jakarta.persistence.*


@Entity
@Table(name = "person")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String,

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String,

    @Column(nullable = false, length = 100)
    var address: String,

    @Column(nullable = false, length = 6)
    @Enumerated(EnumType.STRING)
    var gender: Gender
) {

    constructor(
        firstName: String,
        lastName: String,
        address: String,
        gender: Gender
    ) : this(0, firstName, lastName, address, gender)


    constructor(request: PersonRequest) : this(request.firstName, request.lastName, request.address, request.gender)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        return result
    }

    override fun toString() =
        "Person(id=$id, firstName='$firstName', lastName='$lastName', address='$address', gender=${gender.genderValue})"

}