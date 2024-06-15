fun main() {
    val num_list = listOf(1, 2, 3, 4, 5)
    val result = num_list
        .map { it * it }
        .filter { it % 2 != 0 }
        .reduce { sum, i -> sum + i }
        
	println("List : $num_list")
    println("sum of the squares of the odd numbers from the list = $result")
}
