fun String.isPalindrome(): Boolean {
    val str = this.toLowerCase()
    var i = 0
    var j = str.length - 1

    while (i < j) {
        if (str[i] != str[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

fun main() {
    val str = "madam"
		if(str.isPalindrome()){
            println("yes, $str is palindrome")
        }
        else{
            println("no , $str is not a palindrome")
        }
}
