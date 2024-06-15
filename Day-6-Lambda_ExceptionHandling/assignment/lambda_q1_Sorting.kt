fun sortByNameAge(pairs_list: List<Pair<String, Int>>): List<Pair<String, Int>> {
    return pairs_list.sortedBy { it.second }
}

fun main() {
    val nameAgePairs = listOf(Pair("Swati", 21), Pair("Xyz", 25), Pair("abc", 18))
    val sortedPairs = sortByNameAge(nameAgePairs)
    println("Original list : " + nameAgePairs)
    println("Sorted list of pairs : " + sortedPairs)
}
