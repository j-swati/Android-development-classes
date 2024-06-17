// GCD 

fun main() {
    var num1 = 20
    var num2 = 30
    
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    
    println("GCD : $num1");

    
}