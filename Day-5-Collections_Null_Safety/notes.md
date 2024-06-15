### Collections in Kotlin

- Collections are data structures that store multiple elements. They are used to group related data together and provide various operations to manipulate that data efficiently.
- Kotlin offers a rich set of collection types with various characteristics and capabilities, including lists, sets, and maps.

### 1. List

A `List` is an ordered collection that allows duplicate elements. Each element in the list can be accessed by its index.

- **Immutable List**: Read-only list that cannot be modified after its creation.
    
    ```kotlin
    val readOnlyList: List<String> = listOf("Apple", "Banana", "Cherry")
    // readOnlyList[0] = "Apricot" // Error: cannot modify
    
    ```
    
- **Mutable List**: A list that can be modified, allowing addition, removal, and updating of elements.
    
    ```kotlin
    val mutableList: MutableList<String> = mutableListOf("Apple", "Banana", "Cherry")
    mutableList.add("Date")
    mutableList[0] = "Apricot"
    println(mutableList) // Outputs: [Apricot, Banana, Cherry, Date]
    
    ```
    

### 2. Set

A `Set` is an unordered collection that does not allow duplicate elements. It is useful when you want to store unique items.

- **Immutable Set**: A read-only set.
    
    ```kotlin
    val readOnlySet: Set<String> = setOf("Apple", "Banana", "Cherry")
    // readOnlySet.add("Date") // Error: cannot modify
    
    ```
    
- **Mutable Set**: A set that can be modified.
    
    ```kotlin
    val mutableSet: MutableSet<String> = mutableSetOf("Apple", "Banana", "Cherry")
    mutableSet.add("Date")
    println(mutableSet) // Outputs: [Apple, Banana, Cherry, Date]
    
    ```
    

### 3. Map

A `Map` is a collection of key-value pairs where each key is unique. It is useful when you need to associate values with keys.

- **Immutable Map**: A read-only map.
    
    ```kotlin
    val readOnlyMap: Map<String, Int> = mapOf("Apple" to 1, "Banana" to 2, "Cherry" to 3)
    // readOnlyMap["Date"] = 4 // Error: cannot modify
    
    ```
    
- **Mutable Map**: A map that can be modified.
    
    ```kotlin
    val mutableMap: MutableMap<String, Int> = mutableMapOf("Apple" to 1, "Banana" to 2, "Cherry" to 3)
    mutableMap["Date"] = 4
    println(mutableMap) // Outputs: {Apple=1, Banana=2, Cherry=3, Date=4}
    
    ```
    

### Higher-Order Functions

functions that takes one or more functions as parameters, returns a function, or both.
enables functional programming techniques.

### Example of a Higher-Order Function

Here’s a simple example of a higher-order function that takes another function as a parameter:

```kotlin
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    val result = calculate(3, 4, ::add)
    println(result) // Outputs: 7
}

```

Here’s a diagram to illustrate the flow:

```scss
main() {
    calculate(3, 4, ::add)  -->  calculate(3, 4, add)
                                 operation(3, 4)  -->  add(3, 4)
                                                       return 7
    println(7)
}

```

### Built-in Higher-Order Functions in Kotlin

Kotlin provides several built-in higher-order functions that are commonly used for collection processing and functional programming. Here are some of the most important ones:

### 1. `map`

The `map` function transforms each element in a collection using a given function and returns a new collection containing the transformed elements.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val doubled = numbers.map { it * 2 }
println(doubled) // Outputs: [2, 4, 6, 8, 10]

```

### 2. `filter`

The `filter` function returns a new collection containing only the elements that match a given predicate.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { it % 2 == 0 }
println(evenNumbers) // Outputs: [2, 4]

```

### 3. `find`

The `find` function returns the first element that matches the given predicate, or `null` if no such element is found.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val firstEven = numbers.find { it % 2 == 0 }
println(firstEven) // Outputs: 2

```

### 4. `forEach`

The `forEach` function performs the given action on each element of the collection.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
numbers.forEach { println(it) }
// Outputs:
// 1
// 2
// 3
// 4
// 5

```

### 5. `reduce`

The `reduce` function applies a binary operation to each element in the collection, from left to right, to reduce the collection to a single value.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val sum = numbers.reduce { acc, num -> acc + num }
println(sum) // Outputs: 15

```

### 6. `fold`

The `fold` function is similar to `reduce`, but it takes an initial accumulator value and applies the operation to each element, including the initial value in the operation.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val sum = numbers.fold(0) { acc, num -> acc + num }
println(sum) // Outputs: 15

```

### 7. `flatMap`

The `flatMap` function transforms each element of a collection into a collection of elements and then flattens the resulting collections into a single collection.

```kotlin
val nestedNumbers = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
val flatList = nestedNumbers.flatMap { it }
println(flatList) // Outputs: [1, 2, 3, 4, 5, 6]

```

### 8. `groupBy`

The `groupBy` function groups elements of the collection by a given key selector function.

```kotlin
val words = listOf("apple", "banana", "cherry", "apricot", "blueberry")
val groupedByFirstLetter = words.groupBy { it.first() }
println(groupedByFirstLetter) // Outputs: {a=[apple, apricot], b=[banana, blueberry], c=[cherry]}

```

### 9. `partition`

The `partition` function splits the collection into two collections based on a given predicate. The first collection contains elements that match the predicate, and the second contains elements that do not.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val (evens, odds) = numbers.partition { it % 2 == 0 }
println(evens) // Outputs: [2, 4]
println(odds)  // Outputs: [1, 3, 5]

```

### Examples

**Q**: Given a list of numbers, double each number, filter out the even numbers, and find the first number greater than 10.

**Solution**:

```kotlin
val numbers = listOf(3, 5, 7, 9, 10, 11, 12)
val result = numbers
    .map { it * 2 }  // Double each number
    .filter { it % 2 != 0 }  // Filter out even numbers
    .find { it > 10 }  // Find the first number greater than 10

println(result) // Outputs: 22

```

**Q**: Given a list of words, group them by their first letter, filter out groups with more than one word, and convert each word to uppercase.

**Solution**:

```kotlin
val words = listOf("apple", "banana", "cherry", "apricot", "blueberry", "avocado")
val result = words
    .groupBy { it.first() }  // Group by first letter
    .filter { it.value.size > 1 }  // Filter out groups with more than one word
    .mapValues { it.value.map { word -> word.uppercase() } }  // Convert each word to uppercase

println(result) // Outputs: {a=[APPLE, APRICOT, AVOCADO], b=[BANANA, BLUEBERRY]}

```

**Q**: Given a list of lists of numbers, flatten it into a single list, double each number, and then calculate the sum of all numbers.

**Solution**:

```kotlin
val nestedNumbers = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
val result = nestedNumbers
    .flatMap { it }  // Flatten into a single list
    .map { it * 2 }  // Double each number
    .reduce { acc, num -> acc + num }  // Calculate the sum of all numbers

println(result) // Outputs: 42

```

**Q**: Given a list of numbers, partition it into even and odd numbers, double each number in both partitions, and then find the product of all numbers in both partitions.

**Solution**:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val (evens, odds) = numbers.partition { it % 2 == 0 }  // Partition into evens and odds

val evenProduct = evens
    .map { it * 2 }  // Double each number
    .fold(1) { acc, num -> acc * num }  // Find the product of all numbers

val oddProduct = odds
    .map { it * 2 }  // Double each number
    .fold(1) { acc, num -> acc * num }  // Find the product of all numbers

println("Even Product: $evenProduct") // Outputs: Even Product: 16
println("Odd Product: $oddProduct") // Outputs: Odd Product: 80

```

**Q**: Given a list of words, filter out words shorter than 5 characters, convert each word to uppercase, and then group them by their length.

**Solution**:

```kotlin
val words = listOf("apple", "banana", "cherry", "date", "elderberry", "fig", "grape")
val result = words
    .filter { it.length >= 5 }  // Filter out words shorter than 5 characters
    .map { it.uppercase() }  // Convert each word to uppercase
    .groupBy { it.length }  // Group by word length

println(result) // Outputs: {5=[APPLE, GRAPE], 6=[BANANA, CHERRY], 10=[ELDERBERRY]}

```

### Null Safety

- Null safety helps prevent null reference errors at runtime.
- It guarantees that variables won't unintentionally hold null values, reducing the risk of crashes.
- Without null safety, accessing variables that might be null can lead to runtime exceptions.
- Runtime failures can be problematic, especially in end-user applications

### **How Does Null Safety Work?**

- Null safety enforces non-nullable and nullable types:
    - Non-nullable types
        - Variables declared without a `?` are non-nullable (e.g., `Int`, `String`).
        - They cannot hold null values.
    - Nullable types
        - Variables declared with a `?` allow null values (e.g., `Int?`, `String?`).
        - Use safe calls (`?.`) to access properties or methods on nullable objects.
        - Use the Elvis operator (`?:`) for default values when a nullable value is null.
- Smart casts:
    - Kotlin automatically casts a nullable type to a non-nullable type within a conditional block.
    - For example:
        
        ```kotlin
        val name: String? = ...
        if (name != null) {
            println("Name: $name") // Smart cast to non-nullable String
        }
        
        ```
        

### **Safe Calls**

- Safe calls allow you to access properties or call methods on nullable objects without risking null pointer exceptions (NPEs).
- The safe call operator is represented by the question mark symbol (`?`).

- Suppose you have a nullable variable `b`:
    
    ```kotlin
    val b: String? = "abc"
    
    ```
    
- To access a property (like `length`) on `b`, use the safe call operator:
    
    ```kotlin
    val l = b?.length
    
    ```
    
- If `b` is null, the expression evaluates to null without throwing an NPE.
- It’s like saying, “If `b` is not null, give me its `length`; otherwise, return null.”

**Example: Safe Calls in Conditions**

- You can use safe calls in conditions:
    
    ```kotlin
    if (b != null && b.length > 0) {
        println("String of length ${b.length}")
    } else {
        println("Empty string")
    }
    
    ```
    
- The safe call ensures that accessing `b.length` won’t crash even if `b` is null.

### **Elvis operator** -

A concise way to handle nullable values and provide default values when dealing with null references. 

1. **Syntax**:
    - The Elvis operator is denoted by `?:`.
    - It receives two inputs: `a` and `b`.
    - It returns `a` if `a` is non-null; otherwise, it returns `b`.
2. **Use Cases**:
    - Assigning a default value:
        
        ```kotlin
        val name: String? = ...
        val displayName = name ?: "Guest"
        
        ```
        
        - If `name` is not null, `displayName` gets the value of `name`.
        - If `name` is null, `displayName` gets the fallback value `"Guest"`.
3. **Readability and Null Safety**:
    - The Elvis operator simplifies null checks and enhances code readability.
    - It prevents null pointer exceptions by ensuring a non-null result.

### **Safe cast operator**

It is denoted by the keyword `as?`. This operator provides an added layer of safety when casting objects to a specific type. 

1. Suppose you have an object `obj` of type `Any` (which can hold any value):
    
    ```kotlin
    val obj: Any = "Hello"
    
    ```
    
2. To safely cast `obj` to a `String`, you can use the safe cast operator:
    
    ```kotlin
    val castedString: String? = obj as? String
    
    ```
    
3. The result of this cast will be:
    - If `obj` can be securely cast to a `String`, `castedString` will hold that value.
    - If the cast is not possible (e.g., `obj` is not a `String`), `castedString` will be `null`.

Using the safe cast operator helps avoid runtime exceptions related to type casting. 

### Let function

The `let` function in Kotlin is a powerful scoping function that allows you to execute a block of code within the context of an object. 

- `let` is one of Kotlin’s scope functions.
- It enables you to work with an object within a temporary scope.
- You can use it to perform operations on an object, especially when dealing with nullable values.
- The syntax for `let`
    
    ```kotlin
    val result = someObject.let { /* code block */ }
    
    ```
    
- Inside the curly braces, you can manipulate the `someObject`.
- The result of the last expression in the block becomes the value of `result`.

**Use Cases**:

- **Safe Calls and Null Safety**:
    - Use `let` to perform null-safe operations:
        
        ```kotlin
        val name: String? = ...
        name?.let { println("Name: $it") }
        
        ```
        
    - The code block executes only if `name` is not null.
- **Mapping and Transformation**:
    - You can map an object to another value:
        
        ```kotlin
        val upperStr = str.let { it.toUpperCase() }
        
        ```
        
- **Introducing New Variables**:
    - If you need temporary variables confined to the `let` scope:
        
        ```kotlin
        val result = someObject.let { obj ->
            // Use 'obj' here
            // ...
            // Return a value
        }
        
        ```