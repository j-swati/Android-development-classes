fun transformStrings(string_list: List<String>, transformer: (String) -> String): List<String> {
    return string_list.map(transformer)
}

fun main() {
    val string_list = listOf("kotlin", "is", "fun")
    val res = transformStrings(string_list){ 
        it.uppercase() 
    }
    println("List : $string_list")
    println("Result : $res")
}
