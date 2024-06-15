### Coding Questions on Coroutines in Kotlin:

1. **Basic Coroutine Example:**
    - Write a simple coroutine in Kotlin that prints "Hello" and then "World" after a 1-second delay.

2. **Coroutine with Exception Handling:**
    - Write a coroutine in Kotlin that handles exceptions during the execution of tasks.

3. **Basic try-catch Example:**
    - Write a Kotlin function that takes two integers and divides the first by the second. Use a try-catch block to handle any potential division by zero exceptions and return a meaningful error message.
    - Create a custom exception class in Kotlin called `InvalidAgeException`. Write a function that checks a person's age and throws `InvalidAgeException` if the age is less than 18.
    - Write a Kotlin function that accesses an array element by index. Use a `finally` block to print a message indicating the end of the operation, regardless of whether an exception was thrown.

4. **Coroutine with Timeout:**
    - Write a Kotlin program using coroutines that performs a long-running task but cancels it if it takes more than 2 seconds to complete. Use the `withTimeout` function to achieve this.

### Advanced Coding Questions on Lambdas in Kotlin:

1. **Lambda for Sorting:**
    - Write a Kotlin function that takes a list of pairs containing a name and age, and returns the list sorted by age using a lambda function.

2. **Functional Programming:**
    - Write a Kotlin program that uses `map`, `filter`, and `reduce` functions with lambdas to process a list of numbers. First, square all the numbers, then filter out the even numbers, and finally sum the remaining numbers.

3. **Lambda with Closures:**
    - Write a Kotlin function that uses a lambda to create a closure. The function should return a lambda that adds a given number to its input.

4. **Lambda with Higher-Order Functions:**
    - Write a Kotlin function that takes another function as a parameter and uses it to transform a list of strings.

5. **Lambdas with Collections:**
    - Write a Kotlin function that uses lambdas to perform a sequence of operations on a list of strings: filter the strings to include only those starting with a specific letter, convert them to uppercase, and then sort them alphabetically.

6. **Lambda with Return Type Inference:**
    - Write a Kotlin function that uses a lambda to calculate the factorial of a given number. The lambda should be assigned to a variable, and the function should use this lambda to compute the factorial.
