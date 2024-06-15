fun printUppercase(str: String?) {
    str?.let { println(it.toUpperCase()) } ?: run { println("String is null") }
}

fun main() {
    val str1: String? = "Hello World"
    val str2: String? = null

    printUppercase(str1)
    printUppercase(str2)
}
