interface Drawable {
    fun draw()
    fun resize()
}

class Square : Drawable {
    override fun draw() {
        println("Drawing Square")
    }

    override fun resize() {
        println("Resizing Square")
    }
}

class Triangle : Drawable {
    override fun draw() {
        println("Drawing Triangle")
    }

    override fun resize() {
        println("Resizing Triangle")
    }
}

fun main() {
    val square = Square()
    val triangle = Triangle()

    square.draw()
    square.resize()

    triangle.draw()
    triangle.resize()
}
