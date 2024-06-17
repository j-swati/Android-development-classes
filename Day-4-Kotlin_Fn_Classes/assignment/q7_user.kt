class User(val name: String, val age: Int) {
    companion object {
        fun createUserWithDefaultAge(name: String): User {
            return User(name, 18)
        }
        fun createUser(name: String = "Unknown", age: Int = 18): User {
            return User(name, age)
        }
    }
}

fun main() {
    val userWithDefaultAge = User.createUserWithDefaultAge("Abc")
    println("User with default age: ${userWithDefaultAge.name}, ${userWithDefaultAge.age}")

    val user1 = User.createUser("Swati", 21)
    println("User 1: ${user1.name}, ${user1.age}")

    val user2 = User.createUser("Rishi")
    println("User 2: ${user2.name}, ${user2.age}")

    val user3 = User.createUser()
    println("User 3: ${user3.name}, ${user3.age}")
}
