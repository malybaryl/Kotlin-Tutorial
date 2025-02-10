/*
| Modifier     | Mutable | Can be Null | Scope               | Late Initialization | Thread-Safety |
|-------------|---------|------------|----------------------|----------------------|---------------|
| val         | No      | Yes/No      | Block, Class, Global| No                   | Yes           |
| var         | Yes     | Yes/No      | Block, Class, Global| No (except lateinit) | No            |
| const val   | No      | No          | Top-level, Object   | Not needed           | Yes           |
| lateinit var| Yes     | No          | Class properties    | Yes                  | No            |
| lazy        | No      | No          | Class properties    | Yes (first access)   | Yes           |

**Descriptions:**
- `val` → Immutable variable (cannot be reassigned), but the object it points to may be mutable.
- `var` → Mutable variable (can be reassigned).
- `const val` → Compile-time constant, only works with top-level or `object` properties.
- `lateinit var` → Allows late initialization of non-nullable properties (`var` only, no primitive types).
- `lazy` → Delays initialization until first use, useful for expensive operations.

**Example Usage:**
```kotlin
val name: String = "John"          // Immutable
var age: Int = 25                  // Mutable
const val PI: Double = 3.1415       // Constant at compile-time
lateinit var address: String        // Late initialized variable
val database by lazy { Database() } // Lazy initialization
*/

/*
| Type          | Description                                            | Size (in memory)      | Default Value    | Mutable/Immutable |
|---------------|--------------------------------------------------------|-----------------------|------------------|--------------------|
| Byte          | 8-bit signed integer, ranges from -128 to 127          | 1 byte                | 0                | Immutable          |
| Short         | 16-bit signed integer, ranges from -32,768 to 32,767   | 2 bytes               | 0                | Immutable          |
| Int           | 32-bit signed integer, ranges from -2^31 to 2^31-1     | 4 bytes               | 0                | Immutable          |
| Long          | 64-bit signed integer, ranges from -2^63 to 2^63-1     | 8 bytes               | 0L               | Immutable          |
| Float         | 32-bit floating-point number                           | 4 bytes               | 0.0f             | Immutable          |
| Double        | 64-bit floating-point number                           | 8 bytes               | 0.0              | Immutable          |
| Char          | Single 16-bit Unicode character                        | 2 bytes               | '\u0000' (null char) | Immutable          |
| String        | Sequence of characters (UTF-16 encoding)               | 2 bytes per character + object metadata | "" (empty string) | Immutable          |
| Boolean       | Represents `true` or `false` values                    | 1 byte (platform dependent, usually 1 byte) | false             | Immutable          |
| Array         | Fixed-size collection of elements of a given type      | Depends on the type of elements (e.g., `IntArray` is 4 bytes per element) | Empty array (`[]`) | Mutable            |
| List          | Immutable list of elements                             | Depends on the list size and type of elements | Empty list (`[]`) | Immutable          |
| MutableList   | Mutable list of elements                               | Depends on the list size and type of elements | Empty list (`[]`) | Mutable            |
| Map           | Key-value pairs collection (immutable)                 | Depends on size and types of keys/values | Empty map (`[]`) | Immutable          |
| MutableMap    | Mutable key-value pairs collection                     | Depends on size and types of keys/values | Empty map (`[]`) | Mutable            |

**Type Descriptions:**
- `Byte`: Represents a small number, used for conserving memory when the range of numbers is small.
- `Short`: Represents a small integer, typically used when memory usage is a concern (e.g., file sizes, ranges).
- `Int`: The most commonly used integer type, for general purpose calculations.
- `Long`: Used for large integer values, where the range of `Int` is not sufficient.
- `Float`: 32-bit floating point number, used for less precision when working with decimal values (e.g., graphics, approximations).
- `Double`: 64-bit floating point number, used for high precision decimal calculations (e.g., financial calculations).
- `Char`: Used to represent a single character. Each character takes 2 bytes (UTF-16 encoding).
- `String`: A sequence of characters (immutable). Each character is 2 bytes in size (UTF-16).
- `Boolean`: A true/false value, commonly used in control flow.
- `Array`: A fixed-size collection of elements, where the element type is specified (e.g., `IntArray`).
- `List`: An immutable ordered collection of elements. It can be accessed by index, and its size cannot be changed after creation.
- `MutableList`: A mutable list, meaning elements can be added, removed, or modified.
- `Map`: An immutable collection of key-value pairs, where each key maps to a specific value.
- `MutableMap`: A mutable collection of key-value pairs, where you can add, remove, and modify key-value pairs.

**Example Usage:**
```kotlin
val byteValue: Byte = 127        // Byte
val shortValue: Short = 32767    // Short
val intValue: Int = 1000        // Int
val longValue: Long = 100000L    // Long
val floatValue: Float = 3.14f    // Float
val doubleValue: Double = 3.14159 // Double
val charValue: Char = 'A'        // Char
val stringValue: String = "Hello, Kotlin" // String
val booleanValue: Boolean = true  // Boolean
val arrayValue: Array<Int> = arrayOf(1, 2, 3) // Array
val listValue: List<String> = listOf("Apple", "Banana") // List
val mutableListValue: MutableList<String> = mutableListOf("Apple", "Banana") // MutableList
val mapValue: Map<String, Int> = mapOf("One" to 1, "Two" to 2) // Map
val mutableMapValue: MutableMap<String, Int> = mutableMapOf("One" to 1, "Two" to 2) // MutableMap
*/

// We can make variables outside of functions

//* top level variables */
var name3: String = "John"
val name4: String = "John"

//! var name5: String = null // error
//! name5 is not nullable by default
//? How to make it nullable // add "?"
//* now name5 is nullable or can be String */
var name5: String? = null

val greeding: String = "Hello"

// auto type inferrence
var name6 = "John"

var name7: String? = "John"

fun main(){
    // mutables
    var name2: String = "John"
    println(greeding)
    println(name2)
    name2 = "Jane"
    name3 = "Bye"
    println(name3)
    println(name2)
    
    // const (read only)
    val name: String = "John"
    //! name = "Jane" error
    println(name)

    println(name6)
    //! name6 = null error because name6 is not nullable by default

    //! name6 = 2 error because name6 is String
}