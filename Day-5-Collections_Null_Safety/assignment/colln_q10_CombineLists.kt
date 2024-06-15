fun alternateLists(list1: List<Int>, list2: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (i < list1.size || j < list2.size) {
        if (i < list1.size) {
            result.add(list1[i])
            i++
        }
        if (j < list2.size) {
            result.add(list2[j])
            j++
        }
    }

    return result
}

fun main() {
    val list1 = listOf(1, 3, 5, 7)
    val list2 = listOf(2, 4, 6)
    println("List1 : $list1")
    println("List2 : $list2")
    val result = alternateLists(list1, list2)
    println("\nResult: $result")
}
