fun freq_count(num_list: List<Int>): Map<Int, Int> {
    val freq_Map = mutableMapOf<Int, Int>()

    for (n in num_list) {
        if (freq_Map.containsKey(n)) {
            freq_Map[n] = freq_Map[n]!! + 1
        } else {
            freq_Map[n] = 1
        }
    }

    return freq_Map
}

fun main() {
    val num_list = listOf(1, 2, 2, 3, 3, 3, 4, 5, 5, 7, 7, 7, 7)
    val result = freq_count(num_list)

    println("Frequency Map:")
    println(result)

    println("\nNumber\tFrequency")
    for ((number, frequency) in result) {
        println("$number\t$frequency")
    }
}
