// DUCK NUMBER - A NUMBER WHICH HAS ZEROES PRESENT IN IT

fun main() {
    var num = 1005;
    var flag = 0;
    var temp = num;
    while(temp!=0){
        var digit = temp%10;
        if(digit == 0){
            flag = 1;
        }
        temp/=10;
    }
    if(flag==1){
        println("Duck number");
    }
    else{
        println("Not a Duck number");
    }
}