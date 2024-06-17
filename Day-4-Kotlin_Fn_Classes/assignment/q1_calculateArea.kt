fun main() {
    println("Area of Rectangle : ${calculateArea(7, 10)}")
    println("Area of Circle : ${calculateArea(5.0f)}")
}

fun calculateArea(length: Int, breadth: Int): Int {
    return length * breadth
}

fun calculateArea(radius: Float): Float {
    return 3.14f * radius * radius
}