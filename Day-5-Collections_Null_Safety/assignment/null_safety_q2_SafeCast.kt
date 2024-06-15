fun filterStrings(input_List: List<Any>): List<String> {
    val str_List = mutableListOf<String>()

    for (i in input_List) {
        val ele = i as? String
        if (ele != null) {
            str_List.add(ele)
        }
    }
    return str_List
}

fun main() {
    val mixedList: List<Any> = listOf("apple", 1, "banana", 2, "carrot", 3)
    val filteredStrings = filterStrings(mixedList)
    println("Original List : $mixedList")
    println("Filtered List : $filteredStrings")
}
