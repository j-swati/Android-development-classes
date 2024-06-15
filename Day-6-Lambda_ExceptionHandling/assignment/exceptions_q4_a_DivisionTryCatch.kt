fun main() {
    val res1 = divide(15, 5)
    val res2 = divide(10, 0)
    println(res1)
    println(res2)
}

fun divide(dividend: Int, divisor: Int): String {
    return try {
        "$dividend/$divisor = ${dividend / divisor}"
    } catch (e: ArithmeticException) {
        "$dividend/$divisor -> Cannot divide by zero"
    }
}
