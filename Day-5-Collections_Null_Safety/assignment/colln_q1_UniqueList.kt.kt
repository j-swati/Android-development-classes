class UniqueList {
    val ele_list = mutableSetOf<Int>()

    fun add(element: Int): Boolean {
        return ele_list.add(element)
    }

    fun remove(element: Int): Boolean {
        return ele_list.remove(element)
    }

    fun contains(element: Int): Boolean {
        return ele_list.contains(element)
    }

    fun size(): Int {
        return ele_list.size
    }

    fun isEmpty(): Boolean {
        return ele_list.isEmpty()
    }

    override fun toString(): String {
        return ele_list.toString()
    }
}

fun main() {
    val unique_List = UniqueList()

    println(unique_List.add(1))
    println(unique_List.add(2))
    println(unique_List.add(3))
    println(unique_List.add(1))
    println(unique_List.add(2))
    println(unique_List.add(3))

    println(unique_List.contains(1))
    println(unique_List.contains(5))

    println(unique_List.remove(3))
    println(unique_List.remove(3))

    println(unique_List.size())
    println(unique_List.isEmpty())

    println(unique_List)
}
