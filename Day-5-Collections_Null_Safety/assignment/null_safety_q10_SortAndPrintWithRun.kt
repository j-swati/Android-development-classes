fun printList(list: List<Int>?) {
    list?.run {
        val sorted_List = sorted()
        println("Sorted List: $sorted_List")
    }
}

fun main() {
    val input_List: List<Int>? = listOf(1, 2, 5, 9, 2, 6, 5, 3, 5)

    printList(input_List)
}
