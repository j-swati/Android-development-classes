fun seq_operns(string_list: List<String>, letter: Char): List<String> {
    return string_list
        .filter { it.startsWith(letter, ignoreCase = true) }
        .map { it.uppercase() }
        .sorted()
}

fun main() {
    val string_list = listOf("apple", "banana", "orange", "grapes", "pineapple", "blueberry")
    val res = seq_operns(string_list, 'b')
    println("List : $string_list")
    println("Result : $res")
}
