fun flattenAndRemoveDuplicates(nested_List: List<List<Int>>): List<Int> {
    return nested_List.flatten().distinct()
}

fun main() {
    val listOfLists = listOf(listOf(1, 2, 2), listOf(3, 3, 4), listOf(5, 5, 6), listOf(7, 7, 8))
    val result = flattenAndRemoveDuplicates(listOfLists)
    println(result)
}
