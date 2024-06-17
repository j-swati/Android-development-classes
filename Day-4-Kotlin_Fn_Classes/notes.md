### Function

A function is a reusable block of code designed to perform a specific task.

### Function Call

Calling a function means invoking the function to execute its code.

### Components of a Function

- **Name**: The identifier by which the function can be called.
- **Parameters**: Values passed to the function.
- **Return Type**: The type of value the function returns.
- **Body**: The block of code executed when the function is called.

Example:

```kotlin
fun add(a: Int, b: Int): Int { // Name: add, Parameters: a, b, Return Type: Int, Body: { ... }
    return a + b
}

fun main() {
    val result = add(2, 3) // Function call
    println(result)
}

```

### Default Arguments

- allows us to specify a default value for a function parameter.
- If the caller doesn’t provide a value for that parameter, the default value will be used.

```kotlin
fun greet(name: String = "Guest") {
    println("Hello, $name!")
}

fun main() {
    greet() // Uses default value
    greet("Swati") // Overrides default value
}
```

### Named Arguments

You can specify the names of the arguments to make the function call more readable.

```kotlin
fun displayInfo(name: String, age: Int) {
    println("Name: $name, Age: $age")
}

fun main() {
    displayInfo(age = 21, name = "Swati") // Named arguments
}

```

### Vararg

Allows you to pass a variable number of arguments to a function.

```kotlin
fun printAll(vararg numbers: Int) {
    for (number in numbers) {
        println(number)
    }
}

fun main() {
    printAll(1, 2, 3, 4)
}

```

### Single Expression Function

A function that consists of a single expression can be written in a concise way.

```kotlin
fun double(x: Int) = x * 2

fun main() {
    println(double(4))
}

```

### Class

A class is a blueprint for creating objects.

### Object

An instance of a class.

### Class Components

- **Properties**: Attributes/data members of a class.
- **Member Methods**: Functions defined within a class.

### Basic Class Definition

```kotlin
class Car(val brand: String, val model: String, var year: Int)

fun main() {
    val myCar = Car("Toyota", "Corolla", 2020) // Object
    println("${myCar.brand} ${myCar.model} ${myCar.year}")
}

```

### Primary Constructors

The main constructor of a class, defined in the class header.

```kotlin
class Person(val name: String, val age: Int)

fun main() {
    val person = Person("Swati", 21)
    println("${person.name} is ${person.age} years old")
}

```

### Secondary Constructors

Additional constructors that provide alternative ways to instantiate the class.

```kotlin
class Person {
    var name: String
    var age: Int

    constructor(name: String) {
        this.name = name
        this.age = 0
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

fun main() {
    val person1 = Person("Rohan")
    val person2 = Person("Swati", 21)
    println("${person1.name} is ${person1.age} years old")
    println("${person2.name} is ${person2.age} years old")
}

```

### Data Class

A class primarily used to hold data with automatic `equals`, `hashCode`, `toString`, and `copy` implementations.

```kotlin
data class User(val name: String, val age: Int)

fun main() {
    val user = User("Swati", 21)
    println(user)
}

```

### Abstract Class

- A class that cannot be instantiated on its own
- may contain abstract methods (methods without a body)
- subclasses must implement these abstract methods

```kotlin
abstract class Animal(val name: String) {
    abstract fun makeSound()
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("Bark")
    }
}

fun main() {
    val dog = Dog("Rex")
    dog.makeSound()
}

```

### Interface

- lists methods taht a class must have, but it doesn’t provide the code for how these methods should work
- contains only method signatures, but not the method bodies
- any class that implements interface must provide the actual code for all the methods defined in the interface

```kotlin
interface Drivable {
    fun drive()
}

class Car : Drivable {
    override fun drive() {
        println("Driving a car")
    }
}

fun main() {
    val car = Car()
    car.drive()
}
```

### Difference Between Abstract Class & Interface

| Feature | Abstract Class | Interface |
| --- | --- | --- |
| Inheritance | Can inherit only one abstract class | Can implement multiple interfaces |
| Constructor | Can have constructors | Cannot have constructors |
| Fields | Can have fields | Cannot have fields |
| Methods | Can have both abstract and concrete methods | All methods are abstract by default (Kotlin allows default methods) |

### Singleton Class

A class designed to have only one instance.

```kotlin
object DatabaseConnection {

    // Initialize the database connection (simulated)
    init {
        println("Database connection created.")
    }

    // Method to simulate a database query
    fun query(sql: String): String {
        // Simulate querying the database
        return "Result of '$sql'"
    }

    // Method to simulate closing the database connection
    fun close() {
        println("Database connection closed.")
    }
}

fun main() {
    // Accessing the Singleton instance and performing a query
    val result1 = DatabaseConnection.query("SELECT * FROM users")
    println(result1)

    // Accessing the Singleton instance again to demonstrate it is the same instance
    val result2 = DatabaseConnection.query("SELECT * FROM orders")
    println(result2)

    // Closing the database connection
    DatabaseConnection.close()

    // Checking if the singleton instance still works after close
    val result3 = DatabaseConnection.query("SELECT * FROM products")
    println(result3)
}
```

### Companion Object

An object that is tied to a class, providing similar functionality to static methods in Java.

```kotlin
class MyClass {
    companion object {
        fun create(): MyClass = MyClass()
    }
}

fun main() {
    val instance = MyClass.create()
    println(instance)
}
```

### Getters & Setters

- methods used to access & modify the values of properties/attributes of an object
- they provide controlled access to object’s state , allowing validation and encapsulation of data.

```kotlin
class Person {
    var age: Int = 0
        get() = field
        set(value) {
            if (value >= 0) field = value
        }
}

fun main() {
    val person = Person()
    person.age = 25
    println(person.age)
}
```

### Extension Functions

allows us to add functions(new functionality) to existing classes without modifying their source code.

```kotlin
fun String.lastChar(): Char = this[this.length - 1]

fun main() {
    println("Kotlin".lastChar())
}
```

### Higher-Order Functions

Functions that take other functions as parameters or return functions.

```kotlin
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val sum = calculate(3, 4) { x, y -> x + y }
    println(sum)
}

```

### Generic Class

A class that can operate on different types of data.

```kotlin
class Box<T>(t: T) {
    var value = t
}

fun main() {
    val intBox = Box(10)
    val stringBox = Box("Hello")
    println(intBox.value)
    println(stringBox.value)
}

```

### Inheritance

A mechanism where a new class inherits the properties and methods of an existing class.

```kotlin
open class Animal {
    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Bark")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()
}

```

### Function Overriding

Providing a specific implementation of a method that is already defined in the parent class.

```kotlin
open class Parent {
    open fun show() {
        println("Parent")
    }
}

class Child : Parent() {
    override fun show() {
        println("Child")
    }
}

fun main() {
    val child = Child()
    child.show()
}

```