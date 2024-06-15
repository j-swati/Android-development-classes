val factorial: (Int) -> Int = { n ->
    if (n == 0) 1 else n * factorial(n - 1)
}

fun main() {
    val num = 5
    val res = factorial(num)
    println("Factorial of $num is: $res")
}
