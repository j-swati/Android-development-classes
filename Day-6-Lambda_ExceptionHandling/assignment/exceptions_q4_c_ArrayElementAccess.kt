fun accessArrayElement(arr: Array<Int>, index: Int): Int? {
    try {
        return arr[index]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Exception: Index out of bounds")
        return null
    } finally {
        println("Operation completed")
    }
}

fun main() {
    val num_list = arrayOf(1, 2, 3, 4, 5)
    val ele = accessArrayElement(num_list, 3)
    println("Element at index 2 is: $ele")

    val invalidEle = accessArrayElement(num_list, 7)
    println("Element at index 5 is: $invalidEle")
}
