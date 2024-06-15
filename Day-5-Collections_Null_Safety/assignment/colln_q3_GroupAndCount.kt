fun groupAndCountStrings(string_list: List<String>): Map<Char, Int> {
    val grouped = string_list.groupBy { it.first() }
    val counts = grouped.mapValues { it.value.size }

    return counts
}

fun main() {
    val string_list =
            listOf(
                    "apple",
                    "grape",
                    "guava",
                    "kiwi",
                    "lemon",
                    "mango",
                    "orange",
                    "banana",
                    "blueberry"
            )
    val res = groupAndCountStrings(string_list)
    println(res)
}
