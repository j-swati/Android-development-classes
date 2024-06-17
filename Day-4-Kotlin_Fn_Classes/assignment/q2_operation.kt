fun main() {
    val result = operation(5, 3) { x, y -> x + y }
    println("Result of operation: $result")
}

fun operation(a: Int, b: Int, func: (Int, Int) -> Int): Int {
    return func(a, b)
}

