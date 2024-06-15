class InvalidAgeException(message: String) : Exception(message)

fun checkAge(age: Int) {
    if (age < 18) {
        throw InvalidAgeException("Age should be >=18")
    } else {
        println("Age is valid.")
    }
}

fun main() {
    try {
        checkAge(16)
    } catch (e: InvalidAgeException) {
        println(e.message)
    }
}
