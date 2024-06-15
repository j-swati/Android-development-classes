class Address(val city: String?)

class Person(val address: Address?)

fun getCity(person: Person): String {
    return person.address?.city ?: "Unknown City"
}

fun main() {
    val address1 = Address("Bhubaneswar")
    val person1 = Person(address1)
    val person2 = Person(null)

    println("Person1's City Name: ${getCity(person1)}")
    println("Person2's City Name: ${getCity(person2)}")
}
