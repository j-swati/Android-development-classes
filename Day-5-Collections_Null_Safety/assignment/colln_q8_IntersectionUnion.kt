fun intersection(list1: List<Int>, list2: List<Int>): List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    return (set1 intersect set2).sorted()
}

fun union(list1: List<Int>, list2: List<Int>): List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    return (set1 union set2).sorted()
}

fun main() {
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = listOf(3, 4, 5, 6, 7, 8, 9, 10)

    val intersection_res = intersection(list1, list2)
    val union_res = union(list1, list2)

    println("List1 : $list1")
    println("List2 : $list2")
    println("\nIntersection: $intersection_res")
    println("Union: $union_res")
}
