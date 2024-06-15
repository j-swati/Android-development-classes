fun addClosure(x: Int): (Int) -> Int {
    return { it + x }
}

fun main() {
    val add5 = addClosure(5)
    println("Add 5 to 7 = ${add5(7)}")
}
