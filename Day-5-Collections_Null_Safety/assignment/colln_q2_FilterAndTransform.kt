fun filterOdd_tranformEven(num_list: List<Int>): List<Int> {
    return num_list.filter { it % 2 == 0 }.map { it * 2 }
}

fun main() {
    val num_list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = filterOdd_tranformEven(num_list)
    println("Transformed list : " + res)
}
