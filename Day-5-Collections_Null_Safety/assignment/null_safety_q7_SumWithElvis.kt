fun sumNullableInts(n1: Int?, n2: Int?): Int {
    return (n1 ?: -1) + (n2 ?: -1)
}

fun main() {
    val a: Int? = 10
    val b: Int? = null

    val c: Int? = 1
    val d: Int? = 5

    val sum1 = sumNullableInts(a, b)
    val sum2 = sumNullableInts(c, d)
    println("$a + $b = $sum1")
    println("$c + $d = $sum2")
}
