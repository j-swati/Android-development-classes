data class Person(val name: String, val age: Int)

fun sortPeopleByAgeAndName(persons: List<Person>): List<Person> {
    return persons.sortedWith(compareBy({ it.age }, { it.name }))
}

fun main() {
    val people =
            listOf(
                    Person("Swati", 21),
                    Person("Rohan", 25),
                    Person("Sneha", 20),
                    Person("Rishi", 35)
            )

    val res = sortPeopleByAgeAndName(people)

    res.forEach { println("${it.name}, ${it.age}") }
}
