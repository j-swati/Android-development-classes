Solutions
Docs
Community
Teach
Play

2.0.0
JVM
Program arguments
Copy link
Share code
Run
fun partitionEvenOdd(num_list: List<Int>): Pair<List<Int>, List<Int>> {
    val even_list = mutableListOf<Int>()
    val odd_list = mutableListOf<Int>()
​
    for (n in num_list) {
        if (n % 2 == 0) {
            even_list.add(n)
        } else {
            odd_list.add(n)
        }
    }
​
    return even_list to odd_list
}
​
fun main() {
    val num_list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val (even_list, odd_list) = partitionEvenOdd(num_list)
    
    println("Even numbers List: $even_list")
    println("Odd numbers List: $odd_list")
}
​
Even numbers List: [2, 4, 6, 8, 10]
Odd numbers List: [1, 3, 5, 7, 9]