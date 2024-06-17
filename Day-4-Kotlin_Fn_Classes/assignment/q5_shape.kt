abstract class Shape {
    abstract fun area(): Double
}

class Rectangle(val length: Double, val width: Double) : Shape() {
    override fun area(): Double {
        return length * width
    }

    fun perimeter(): Double {
        return 2 * (length + width)
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

fun main() {
    val shapes = listOf<Shape>(Rectangle(5.0, 3.0), Circle(4.0))

    for (shape in shapes) {
        println("Area: ${shape.area()}")
        
        if (shape is Rectangle) {
            println("Perimeter: ${shape.perimeter()}")
        } else if (shape is Circle) {
            println("Perimeter: ${shape.perimeter()}")
        }
        
        println()
    }
