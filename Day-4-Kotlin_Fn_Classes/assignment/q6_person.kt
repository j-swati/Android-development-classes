data class Person(val name: String, val age: Int, val address: String)

fun main() {
    val person1 = Person("Swati", 21, "Rayagada")
    val person2 = person1.copy(age = 22, address = "Bhubaneswar")

    println("Original Person: ${person1.name} , ${person1.age} , ${person1.address}")
    println("Original Person: ${person2.name} , ${person2.age} , ${person2.address}")
}
