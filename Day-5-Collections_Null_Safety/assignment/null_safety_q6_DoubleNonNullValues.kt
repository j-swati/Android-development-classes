fun double_NonNullValues(num_list: List<Int?>): List<Int> {
    return num_list.mapNotNull { it?.times(2) }
}

fun main() {
    val num_list = listOf(1, 2, null, 3, null, 4, 5, 6, null, 8, 9)

    val doubledValues = double_NonNullValues(num_list)
    println("Input : $num_list")
    println("Doubled non-null values: $doubledValues")
}
