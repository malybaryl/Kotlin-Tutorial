// 1. `as` - Type cast operator
// - Used to cast an object to a specified type. 
// - In Java, casting is done with (Type) object.
val obj: Any = "Hello"
val str: String = obj as String

// 2. `as?` - Safe type cast operator
// - Used to cast an object to a specified type safely. Returns null if the cast fails.
// - Equivalent to Java's instanceof check followed by a cast.
val strSafe: String? = obj as? String

// 3. `break` - Exit a loop
// - Used to exit from a loop immediately.
// - Same as in Java.
for (i in 1..5) {
    if (i == 3) break  // Exits the loop when i is 3
}

// 4. `class` - Defines a class
// - Same as Java.
class MyClass

// 5. `continue` - Skip the current iteration of a loop
// - Skips the rest of the loop's body and moves to the next iteration.
// - Same as in Java.
for (i in 1..5) {
    if (i == 3) continue  // Skips when i is 3
}

// 6. `crossinline` - Modifier for lambda parameters
// - Used to ensure that a lambda expression doesn't return from the enclosing function.
fun foo(crossinline body: () -> Unit) {
    // body cannot use "return" to exit the enclosing function.
}

// 7. `data` - Defines a data class
// - Automatically generates useful methods like toString(), equals(), and hashCode().
// - Equivalent in Java would be creating a custom class with these methods manually.
data class User(val name: String, val age: Int)

// 8. `do` - Executes a block of code (used with `while` and `while` loops)
// - Same as in Java, used to create a "do-while" loop.
do {
    println("Executing")
} while (false)

// 9. `else` - Used in `if` and `when` expressions as the "default" branch
// - Same as in Java.
val result = if (x > 10) "Greater" else "Lesser"

// 10. `enum` - Defines an enumeration
// - Same as in Java, used to define enum types.
enum class Direction { NORTH, EAST, SOUTH, WEST }

// 11. `false` - Represents the boolean literal false
// - Same as Java.
val isValid: Boolean = false

// 12. `finally` - Used in exception handling for the block of code that always runs
// - Same as in Java.
try {
    // Code that might throw an exception
} catch (e: Exception) {
    // Exception handling
} finally {
    // Always executes regardless of whether an exception occurred
}

// 13. `for` - Loop keyword
// - Used to iterate over ranges or collections.
// - Same as in Java.
for (i in 1..5) {
    println(i)
}

// 14. `fun` - Defines a function
// - Similar to the `def` keyword in some other languages (e.g., Python).
// - Java uses method declarations without a special keyword.
fun sayHello() {
    println("Hello!")
}

// 15. `goto` - Not available in Kotlin (Java also doesn't support `goto`).
// - Kotlin doesn't have `goto` because it encourages structured control flow.


// 16. `if` - Conditional statement
// - Same as in Java.
if (x > 10) {
    println("Greater")
} else {
    println("Lesser")
}

// 17. `import` - Imports other files or classes into the current scope
// - Same as in Java.
import kotlin.math.PI

// 18. `in` - Used in ranges and collections to check membership
// - Similar to Java's `contains()` method for collections.
val numbers = listOf(1, 2, 3, 4)
val contains = 2 in numbers // checks if 2 is in the list

// 19. `infix` - Defines infix functions
// - Used to create functions that can be called in infix notation (without parentheses).
// - Not available in Java.
infix fun Int.add(x: Int) = this + x
println(5 add 3) // Infix notation

// 20. `init` - The initialization block in a class constructor
// - Same as Java, used to initialize an object.
// - Equivalent to the constructor in Java.
class MyClass {
    init {
        println("Object initialized")
    }
}

// 21. `interface` - Defines an interface
// - Same as in Java.
interface Drawable {
    fun draw()
}

// 22. `internal` - Specifies that a member is visible within the same module
// - Kotlin's `internal` is not directly available in Java, but it’s roughly equivalent to package-private access level in Java.
internal val myValue = 10

// 23. `is` - Type checking operator
// - Checks if an object is of a certain type, similar to Java's `instanceof`.
if (obj is String) {
    println("It's a string!")
}

// 24. `it` - The implicit name for a lambda parameter (when only one parameter is needed)
// - This is unique to Kotlin and has no direct equivalent in Java.
val nums = listOf(1, 2, 3)
nums.forEach { println(it) } // "it" refers to the current item in the lambda

// 25. `lateinit` - Used for deferred initialization of non-null variables
// - Equivalent to Java's null checks, but simplifies variable initialization.
lateinit var name: String

// 26. `noinline` - Prevents a lambda expression from being inlined (useful in higher-order functions)
// - Java doesn't have an equivalent, as all lambdas in Java are always "inlined."
fun foo(noinline body: () -> Unit) {
    // Cannot inline body here
}

// 27. `null` - Represents a null value
// - Same as in Java.
val myString: String? = null

// 28. `object` - Defines a singleton or anonymous object
// - Java's equivalent is using the `new` keyword for anonymous classes or using `Singleton` pattern.
object MySingleton {
    val value = 42
}

// 29. `open` - Marks a class or method as inheritable
// - Java uses `extends` for classes and `abstract` for methods.
open class Animal
class Dog : Animal()

// 30. `override` - Used to override a method in a subclass
// - Same as Java's `@Override` annotation.
open class Animal {
    open fun sound() { println("Generic sound") }
}

class Dog : Animal() {
    override fun sound() { println("Bark!") }
}

// 31. `package` - Specifies the package of the current file
// - Same as in Java.
package com.example.kotlin

// 32. `private`, `protected`, `public`, `internal` - Visibility modifiers
// - Same in Java (with minor differences in the way they are used).
private val secret = "Hidden"

// 33. `return` - Returns a value from a function
// - Same as in Java.
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 34. `sealed` - Used to define sealed classes (limited class hierarchy)
// - Java doesn't have an equivalent, but a similar pattern can be achieved with enums or abstract classes.
sealed class Shape
class Circle : Shape()

// 35. `super` - Refers to the superclass in a subclass
// - Same as in Java.
open class Animal
class Dog : Animal() {
    fun callSuper() {
        super.toString() // Calls the superclass method
    }
}

// 36. `this` - Refers to the current instance of a class
// - Same as in Java.
class Person(val name: String) {
    fun greet() {
        println("Hello, my name is $name!")
    }
}

// 37. `throw` - Throws an exception
// - Same as in Java.
throw Exception("An error occurred")

// 38. `try`, `catch`, `finally` - Used for exception handling
// - Same as in Java.
try {
    // Code that might throw an exception
} catch (e: Exception) {
    println("Caught an exception!")
} finally {
    println("Finally block executed.")
}

// 39. `typealias` - Defines an alias for a type
// - Java doesn't have a direct equivalent, but you can use `import` to achieve something similar.
typealias StringList = List<String>
val list: StringList = listOf("one", "two", "three")

// 40. `var`, `val` - Declares mutable and immutable variables
// - `val` is like Java's `final`, and `var` is a mutable variable.
val immutableValue = 10
var mutableValue = 20
