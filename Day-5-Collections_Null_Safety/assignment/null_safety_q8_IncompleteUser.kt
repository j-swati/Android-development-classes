data class User(val name: String?, val email: String?)

fun printUserDetails(user: User) {
    if (user.name == null || user.email == null) {
        println("Incomplete User")
    } else {
        println("User Details:")
        println("Name: ${user.name}")
        println("Email: ${user.email}\n")
    }
}

fun main() {
    val user1 = User("Swati", "swati@abc.com")
    val user2 = User(null, "xyz@gmail.com")
    val user3 = User("Shruti", null)
    val user4 = User(null, null)

    printUserDetails(user1)
    printUserDetails(user2)
    printUserDetails(user3)
    printUserDetails(user4)
}
