### Lambda functions

- Anonymous functions that can be treated as values
- They allow you to create small, single-use functions without having to give them a name
- We can pass them as arguments to functions, return them, or assign them to variables.
- These functions are defined using the `lambda` keyword.

Example:

```kotlin
val sum: (Int, Int) -> Int = { a, b -> a + b }
println(sum(1, 2)) // Output: 3

```

### Inline Functions in Kotlin

- Inline functions in Kotlin are used to optimize higher-order functions, particularly those that take lambda expressions as parameters.
- When a function is marked with the `inline` keyword, the compiler attempts to inline the function's code at the call site, thus avoiding the overhead of function calls and enabling more efficient bytecode.

### Benefits of Inline Functions

1. **Reduced Overhead**: Avoids the overhead of creating function objects and performing calls.
2. **Improved Performance**: Can lead to better performance, especially in scenarios with frequent function calls.
3. **Non-local Returns**: Allows lambda expressions to return from the enclosing function.

**Here’s an example of an inline function:**

```kotlin
inline fun performOperation(number: Int, operation: (Int) -> Int): Int {
    return operation(number)
}

fun main() {
    val result = performOperation(10) { it * it }
    println("The result of the operation is: $result")
}
```

In this example, **`performOperation`** is an inline function that takes an integer and a lambda as parameters. The lambda **`{ it * it }`** is a simple operation that squares the input number. The **`main`** function calls **`performOperation`** with the number 10 and the squaring lambda, then prints out the result.

### NoInline

Sometimes you might not want all parameters to be inlined. Kotlin provides the **`noinline`** modifier 

```kotlin
inline fun performOperations(
    noinline operation1: (Int) -> Int,
    operation2: (Int) -> Int
): Pair<Int, Int> {
    return Pair(operation1(10), operation2(20))
}

fun main() {
    val (result1, result2) = performOperations(
        { it + it }, // This lambda will not be inlined.
        { it * it }  // This lambda will be inlined.
    )
    println("Result of operation1: $result1")
    println("Result of operation2: $result2")
}
```

In this  example, **`performOperations`** takes two lambdas as parameters. The first lambda is marked with **`noinline`**, so it won’t be inlined, while the second lambda will be. The **`main`** function demonstrates calling **`performOperations`** with two different operations and prints out the results.

### Lambda with Receivers

- In Kotlin, a lambda with receiver is a lambda expression that has a receiver of a specified type.
- This means that within the lambda body, you can call methods on the receiver without any additional qualifiers.
- It’s as if the lambda body is part of the class of the receiver.
- Lambda with receivers is particularly useful when designing domain-specific languages (DSLs) in Kotlin or when working with scoped functions like `apply`, `run`, `with`, and `let`.

Here’s an example using `StringBuilder` as the receiver:

```kotlin
fun buildString(action: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.action()
    return stringBuilder.toString()
}

fun main() {
    val resultString = buildString {
        append("Hello, ")
        append("world!")
    }
    println(resultString) // Output: Hello, world!
}

```

In this example:

- `buildString` is a function that takes a lambda with `StringBuilder` as its receiver.
- Inside the lambda passed to `buildString`, you can directly call `append` without specifying the receiver because `StringBuilder` is the implicit receiver of the lambda.
- The `main` function demonstrates how to use `buildString` to construct a string using the lambda with receiver.

### Domain-Specific Languages (DSLs)

- A DSL is a language specialized to a particular domain or area of interest.
- In Kotlin, DSLs are often implemented using lambdas with receivers, which allows you to create a readable and concise syntax that feels like a natural language.

### Scoped Functions

- Scoped functions allows us to execute a block of code within the context of an object.
- Inside the block, you can access the object without its name.
- They are useful for initializing objects, performing operations on them, and computing results.
- The four main scoped functions are `apply`, `run`, `with`, and `let`.

### 1. `apply`

- The `apply` function is used to initialize an object and configure its properties.
- It returns the object itself after applying the provided configuration block.

```kotlin
val person = Person().apply {
    name = "John"
    age = 30
}
```

### 2. `run`

- The `run` function is similar to `apply`, but it returns the result of the lambda expression.
- It can be used for both object initialization and computation.

```kotlin
val message = StringBuilder().run {
    append("Hello, ")
    append("World!")
    toString()
}
```

### 3. `with`

- The `with` function is used to operate on an object without the need to call its members with the dot notation.

It's particularly useful when you want to perform multiple operations on the same object.

```kotlin
kotlinCopy code
val person = Person("John", 30)
with(person) {
    println("Name: $name, Age: $age")
    // Other operations on person
}
```

### 4. `let`

- The `let` function is used to perform operations on a non-null object.

It passes the object as an argument to the lambda expression and returns the result of the lambda.

```kotlin
kotlinCopy code
val name: String? = "John"
val message = name?.let {
    "Hello, $it"
}
```

**Here's a brief comparison of the four scoped functions:**

- **`apply`**: Use when initializing an object and setting its properties.
- **`run`**: Use when you need to perform operations and computation on an object.
- **`with`**: Use when you want to operate on an object's properties without repeating the object reference.
- **`let`**: Use when you need to perform operations on a non-null object and return a result.

### Type aliases

- Type aliases in Kotlin allow you to create alternative names for existing types.
- They are useful when you want to shorten long generic types, create more readable code, or define a type for a specific use case.

### Syntax

```kotlin
typealias NewTypeName = ExistingType
```

Here’s an example of how to define and use a type alias:

```kotlin
// EXAMPLE -1
typealias StringList = List<String>

fun main() {
    val names: StringList = listOf("Alice", "Bob", "Charlie")
    println(names) // Output: [Alice, Bob, Charlie]
}
```

```kotlin
// EXAMPLE -2
typealias IntOperation = (Int) -> Int

fun main() {
    val square: IntOperation = { number -> number * number }
    val result = square(5)
    println(result) // Output: 25
}
```

### Benefits

1. **Readability**: Type aliases improve code readability by giving meaningful names to complex or verbose types.
2. **Reduced Redundancy**: They reduce redundancy by allowing you to reuse type declarations throughout your codebase.
3. **Abstraction**: They abstract away the implementation details of types, making the code more maintainable and adaptable to changes.

### Capturing Variables

- In Kotlin, lambda expressions can capture variables from their surrounding enclosing scope.
- This means that they can access and use variables defined outside of their own scope.
- This feature, known as "capturing variables," allows lambdas to retain access to variables even after they have gone out of scope.

### Example:

```kotlin
fun main() {
    val outsideVariable = 42

    val lambda: () -> Unit = {
        println("Outside variable captured: $outsideVariable")
    }

    lambda() // Output: Outside variable captured: 42
}
```

In this example, the lambda expression captures the `outsideVariable` from the outer scope and prints its value when invoked.

### Capturing Mutable Variables:

When a lambda captures a mutable variable (e.g., a `var`), it captures the variable's current value at the time the lambda is created. If the variable's value changes later, the lambda will still use the captured value.

```kotlin
fun main() {
    var counter = 0

    val increment: () -> Unit = {
        counter++
        println("Counter: $counter")
    }

    increment() // Output: Counter: 1
    increment() // Output: Counter: 2
}
```

In this example, the `increment` lambda captures the `counter` variable and increments it each time it's invoked. The lambda retains access to the `counter` variable even though it's modified outside of its scope.

### Capturing Variables in Loops:

Capturing variables in loops requires special attention because lambdas are created inside the loop body. If a lambda captures a loop variable, it will use the variable's value at the time it's executed, not at the time it's created.

```kotlin
fun main() {
    val listeners = mutableListOf<() -> Unit>()

    for (i in 1..3) {
        listeners.add {
            println("Listener $i")
        }
    }

    listeners.forEach { it() }
}
```

Output:

```
Listener 3
Listener 3
Listener 3
```

In this example, all lambdas in the `listeners` list capture the loop variable `i`. When the lambdas are executed, they print the value of `i` at that time, which is `3` in all cases.

***Capturing variables can be very useful, but it’s important to be aware of their lifecycle, especially when working with concurrency, to avoid unexpected behavior or memory leaks.***

### Empty Lambda Functions

- An empty lambda function in Kotlin is a lambda expression that doesn't contain any code inside its body.
- It's essentially a placeholder for a function that doesn't perform any actions but serves a syntactical purpose.

### Syntax:

```kotlin
val emptyLambda: () -> Unit = {}
```

In this syntax:

- `() -> Unit` denotes the lambda expression, which takes no arguments and returns `Unit` (similar to `void` in other languages).
- `{}` represents the body of the lambda, which is empty.

### Example:

```kotlin
val emptyLambda: () -> Unit = {}

fun main() {
    emptyLambda()
}
```

In this example, `emptyLambda` is declared as an empty lambda function. When invoked, it doesn't perform any action.

### Use Cases:

1. **Placeholder**: Sometimes, you might need to pass a lambda function to another function but don't require any specific behavior. In such cases, you can use an empty lambda function as a placeholder.
2. **Default Argument**: You can provide an empty lambda function as a default argument to a higher-order function to allow callers to override it with their custom behavior if needed.

### Practical Example:

```kotlin
fun processData(data: List<Int>, action: (Int) -> Unit = {}) {
    data.forEach(action)
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // With custom action
    processData(numbers) { println(it * 2) }

    // Without custom action (empty lambda)
    processData(numbers)
}

```

In this example, the `processData` function processes a list of numbers. It accepts an optional `action` parameter, which is a lambda function applied to each element of the list. By default, it's an empty lambda function, but callers can provide their custom action if needed.

### Callback

- A **callback** is a function that is passed as an argument to another function and is expected to be called at a certain point in time.
- Callbacks are often used for asynchronous operations, event handling, or to customize the behavior of a function.

Here’s an example of using a callback in Kotlin:

```kotlin
fun downloadData(url: String, onComplete: (String) -> Unit) {
    // Simulate data download
    println("Downloading data from $url...")
    // Data downloaded
    val result = "Data from $url"
    onComplete(result)
}

fun main() {
    val url = "http://example.com"
    downloadData(url) { data ->
        println("Received callback with data: $data")
    }
}
```

In this example, `downloadData` takes a URL and a callback function `onComplete`. Once the data is “downloaded”, the callback is invoked with the result.

### Fallback

- A **fallback** refers to an alternative plan or method that will take effect if the first one fails or is unavailable.
- In programming, it’s often used to provide a default behavior or value if something goes wrong.

Here’s an example of implementing a fallback mechanism:

```kotlin
fun fetchDataFromNetwork(): String? {
    // Simulate network fetch
    return null // Let's assume the network request failed
}

fun fetchDataWithFallback(): String {
    val networkData = fetchDataFromNetwork()
    return networkData ?: "Default data" // Fallback to default data if networkData is null
}

fun main() {
    val data = fetchDataWithFallback()
    println(data) // Output: Default data
}
```

In this example, `fetchDataFromNetwork` simulates a network fetch that fails and returns `null`. The `fetchDataWithFallback` function attempts to fetch the data but falls back to “Default data” if the network fetch fails.

### Exception Handling

- Exception handling is a critical aspect of software development aimed at gracefully managing unexpected or exceptional situations that may occur during program execution.
- Kotlin, like many other modern programming languages, provides robust support for handling exceptions through a combination of try-catch blocks, throw statements, and custom exception classes.

### Try-Catch Blocks

The `try-catch` block is used to handle exceptions that might occur within a specific code block. The `try` block contains the code that might throw an exception, and the `catch` block handles the exception if it occurs.

### Syntax:

```kotlin
try {
    // Code that might throw an exception
} catch (e: Exception) {
    // Code to handle the exception
}
```

### Example:

```kotlin
fun divide(a: Int, b: Int): Int {
    return try {
        a / b
    } catch (e: ArithmeticException) {
        println("Error: ${e.message}")
        -1
    }
}

fun main() {
    val result = divide(10, 0)
    println("Result: $result")
}
```

In this example, the `divide` function attempts to perform a division operation within a try block. If a division by zero occurs, an `ArithmeticException` is thrown and caught by the corresponding catch block, which handles the exception by printing an error message and returning -1.

### Throw Statement

The `throw` statement is used to explicitly throw an exception within a function. This allows you to create custom error conditions and propagate them up the call stack for handling.

### Syntax:

```kotlin
throw SomeException("Error message")
```

### Example:

```kotlin
fun validateAge(age: Int) {
    if (age < 0) {
        throw IllegalArgumentException("Age must be non-negative")
    }
}

fun main() {
    try {
        validateAge(-5)
    } catch (e: IllegalArgumentException) {
        println("Invalid age: ${e.message}")
    }
}
```

In this example, the `validateAge` function throws an `IllegalArgumentException` if the provided age is negative. The exception is caught in the `main` function's try-catch block, which handles the error by printing a message.

### Custom Exception Classes

In addition to built-in exception classes like `ArithmeticException` and `IllegalArgumentException`, Kotlin allows you to create custom exception classes to represent specific error conditions in your application.

### Example:

```kotlin
class InvalidAgeException(message: String) : Exception(message)

fun validateAge(age: Int) {
    if (age < 0) {
        throw InvalidAgeException("Age must be non-negative")
    }
}

fun main() {
    try {
        validateAge(-5)
    } catch (e: InvalidAgeException) {
        println("Invalid age: ${e.message}")
    }
}
```

In this example, the `InvalidAgeException` class is a custom exception that extends the `Exception` class. It is used to represent the error condition of an invalid age value. The `validateAge` function throws this custom exception if the provided age is negative.

### Concurrency

- the ability of a system to execute multiple tasks concurrently, allowing for more efficient use of resources and improved responsiveness.
- Kotlin provides various mechanisms for achieving concurrency, including coroutines, threads, and asynchronous programming.

### Coroutines

Coroutines allow you to write asynchronous code in a sequential and imperative style, making it easier to understand and maintain.

### Example:

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is milliseconds)
        println("World!") // print after delay
    }
    println("Hello,") // main coroutine continues while the previous one is delayed
}
```

In this example, 

- **`runBlocking`** is a coroutine builder that blocks the current thread until the coroutine completes.
- **`launch`** creates a new coroutine that runs concurrently with the rest of the code.
- **`delay`** is a special suspending function that doesn’t block the thread but suspends the coroutine for a specific time.

### Threads

- Threads are the most fundamental unit of concurrency in most programming languages.
- In Kotlin, you can create and manage threads using the `Thread` class or the higher-level constructs provided by libraries like `java.util.concurrent`

### Example:

```kotlin
fun main() {
    val thread = Thread {
        Thread.sleep(1000L)
        println("World!")
    }
    thread.start()
    println("Hello,")
    Thread.sleep(2000L)
}
```

In this example, a new thread is created using the `Thread` class, and it prints "World!" after a delay of 1 second. Meanwhile, the main thread continues executing and prints "Hello," before pausing for 2 seconds.

### Asynchronous Programming

- Asynchronous programming involves executing tasks concurrently without blocking the main thread.
- In Kotlin, you can use coroutines or asynchronous functions provided by libraries like `async` and `await`.

### Example with async-await:

```kotlin
import kotlinx.coroutines.*

fun main() {
    val deferred = GlobalScope.async {
        delay(1000L)
        "World!"
    }
    println("Hello,")
    runBlocking {
        println(deferred.await())
    }
}
```

In this example, an asynchronous task is created using `GlobalScope.async`, and it returns "World!" after a delay of 1 second. Meanwhile, the main thread continues executing and prints "Hello," before waiting for the result of the asynchronous task using `await`.

A **suspending function** in Kotlin is a special kind of function that can be paused and resumed at a later time without blocking a thread. Suspending functions are the building blocks of coroutines and are marked with the `suspend` modifier.

Here’s an example of a suspending function:

```kotlin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun doSomething() {
    println("Doing something...")
    delay(1000) // Suspends the coroutine for 1 second
    println("Done!")
}

fun main() = runBlocking { // Creates a coroutine that blocks the main thread
    doSomething() // Calls the suspending function
}

```

In this example:

- `doSomething` is a suspending function because it has the `suspend` modifier.
- `delay` is also a suspending function that comes from the Kotlin coroutines library. It suspends the execution of the coroutine for a specified amount of time without blocking the thread.
- `runBlocking` is used to start a coroutine that blocks the main thread, allowing us to call suspending functions from the `main` function.

### Suspending Function

- A **suspending function** in Kotlin is a special kind of function that can be paused and resumed at a later time without blocking a thread.
- Suspending functions are the building blocks of coroutines and are marked with the `suspend` modifier.

Here’s an example of a suspending function:

```kotlin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun doSomething() {
    println("Doing something...")
    delay(1000) // Suspends the coroutine for 1 second
    println("Done!")
}

fun main() = runBlocking { // Creates a coroutine that blocks the main thread
    doSomething() // Calls the suspending function
}

```

In this example:

- `doSomething` is a suspending function because it has the `suspend` modifier.
- `delay` is also a suspending function that comes from the Kotlin coroutines library. It suspends the execution of the coroutine for a specified amount of time without blocking the thread.
- `runBlocking` is used to start a coroutine that blocks the main thread, allowing us to call suspending functions from the `main` function.

Suspending functions can only be called from other suspending functions or coroutines. They are designed to perform long-running or asynchronous tasks, such as fetching data from a network or performing complex calculations, without blocking the main thread.

### Keep in  mind :-

### 1. UI Changes Happen on the Main Thread

- UI updates and interactions must occur on the main thread or UI thread.
- Performing UI operations on background threads can lead to synchronization issues, unexpected behavior, or even crashes.

### 2. Never Block the Main Thread

- Blocking the main thread with long-running tasks, such as network operations or heavy computations, can freeze the UI and make the app appear unresponsive.
- Use asynchronous techniques like coroutines, threads, or asynchronous APIs to perform such tasks off the main thread.

### Background Thread

- In Kotlin, a **background thread** refers to a thread that runs separately from the main thread
- Typically used for tasks that take a long time to complete, such as network operations or complex calculations.
- This prevents the main thread, which handles UI updates, from being blocked.

**Use cases of `Background Thread`**

1. **Network Operations**: Fetching data from remote servers or APIs.
2. **File I/O**: Reading from or writing to files on disk.
3. **Database Queries**: Performing database operations using SQLite or other databases.
4. **Computation-Intensive Tasks**: Executing CPU-bound computations or algorithms.
5. **Blocking Operations**: Any operation that may block the main thread, such as waiting for user input or processing large datasets.