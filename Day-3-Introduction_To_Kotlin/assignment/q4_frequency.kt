fun main() {
    val str = "hello world"
    val frequency = IntArray(26)
    for (i in str) {
        if (i.isLetter()) {
            val index = i.toLowerCase() - 'a'
            frequency[index]++
        }
    }
    for (i in frequency.indices) {
        if (frequency[i] > 0) {
            println("${(i + 'a'.toInt()).toChar()} : ${frequency[i]}")
        }
    }
}