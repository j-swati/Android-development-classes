### Kotlin Collections Practice Questions

1. **Creating a Custom Collection**
    
    Create a custom collection class in Kotlin that mimics the behavior of a list but only allows unique elements. Implement methods to add, remove, and check for elements, and ensure that duplicates are not added.
    
2. **Filtering and Transforming Collections**
    
    Given a list of numbers, filter out the odd numbers, double the even numbers, and return the resulting list. Use higher-order functions like filter and map.
    
3. **Grouping and Aggregating**
    
    Given a list of strings, group them by their first character and create a map where the keys are the first characters and the values are lists of strings starting with that character. Then, count the number of strings in each group.
    
4. **Flattening Nested Collections**
    
    Given a list of lists of integers, write a function that flattens it into a single list of integers and removes any duplicate values.
    
5. **Frequency Map**
    
    Write a function that takes a list of integers and returns a map where the keys are the integers and the values are the frequency of each integer in the list.
    
6. **Sorting Complex Objects**
    
    Given a list of Person objects (each with name and age properties), sort the list first by age in ascending order and then by name in alphabetical order if ages are equal.
    
7. **Partitioning Collections**
    
    Given a list of integers, partition it into two lists: one containing the even numbers and the other containing the odd numbers. Return both lists.
    
8. **Intersection and Union**
    
    Write functions to find the intersection and union of two lists of integers. Ensure that the results are unique and sorted.
    
9. **Collection Operations with Custom Predicates**
    
    Given a list of strings, write a function that filters out strings that do not match a given predicate (e.g., strings that do not contain a certain substring or strings that are not of a certain length).
    
10. **Combining Collections**
    
    Given two lists of integers, create a new list that alternates elements from each list. If one list is longer, append the remaining elements at the end.
    

### Kotlin Null Safety Practice Questions

1. **Safe Calls and Elvis Operator**
    
    Write a function that takes a nullable string and returns its length if it is not null, or -1 if it is null. Use the safe call operator (?.) and the Elvis operator (?:).
    
2. **Safe Casting with as?**
    
    Given a list of Any type, write a function that filters out all elements that are not strings and returns a list of strings. Use safe casting (as?).
    
3. **Nullability and Collections**
    
    Given a list of nullable integers, write a function that returns a list of non-null integers. Use the filterNotNull function.
    
4. **Optional Type Wrapping**
    
    Create a function that wraps a given value in an Optional type (or a similar custom wrapper) if it is not null, and returns an empty wrapper if it is null.
    
5. **Handling Null with let**
    
    Write a function that takes a nullable string and prints its uppercase version if it is not null, otherwise prints “String is null”. Use the let function.
    
6. **Null Safety with Higher-Order Functions**
    
    Given a list of nullable integers, write a function that doubles the non-null values and returns a list of these doubled values. Use mapNotNull.
    
7. **Elvis Operator in Expressions**
    
    Write a function that takes two nullable integers and returns their sum if both are not null, or -1 if any of them is null. Use the Elvis operator.
    
8. **Null Safety in Data Classes**
    
    Define a data class User with nullable properties name and email. Write a function that prints “Incomplete User” if any property is null, otherwise prints the user’s details.
    
9. **Chaining Safe Calls**
    
    Given a class Person with a nullable property address which is another class with a nullable property city, write a function that returns the city name if it exists, or “Unknown City” if it does not.
    
10. **Scope Functions and Nullability**
    
    Write a function that takes a nullable list of integers and, if it is not null, sorts it and prints the sorted list. Use the run function for this.