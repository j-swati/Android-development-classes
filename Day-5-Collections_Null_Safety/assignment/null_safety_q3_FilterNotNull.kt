fun filterNonNullIntegers(num_list: List<Int?>): List<Int> {
    return num_list.filterNotNull()
}

fun main() {
    val num_list = listOf(1, 2, null, 4, null, 6, 7, null, 9, null)
    val res_list = filterNonNullIntegers(num_list)
    println("Input List : $num_list")
    println("Non-null integers: $res_list")
}
