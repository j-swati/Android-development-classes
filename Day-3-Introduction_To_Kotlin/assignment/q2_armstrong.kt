// ARMSTRONG NUMBER

fun main() {
    var n=153;
    var temp = n;
    var sum = 0;
    while(temp!=0){
        var digit = temp%10;
        sum+=digit*digit*digit;
        temp/=10;
    }
    if(sum == n){
        println("Yes, $n is an Armstrong number");
    }
    else{
        println("No, $n is not an Armstrong number");
    }
    
}