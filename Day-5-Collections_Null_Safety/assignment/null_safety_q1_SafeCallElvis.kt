fun getLength(str: String?): Int {
    return str?.length ?: -1
}

fun main() {
    val str1: String? = "Hello World"
    val str2: String? = null

    val len1 = getLength(str1)
    val len2 = getLength(str2)

    println("String1 : $str1")
    println("String2 : $str2\n")
    println("Length of string1: $len1")
    println("Length of string2: $len2")
}
