// Kotlin supports a variety of operators, many of which have equivalents in Java. 
// Below is a list of common Kotlin operators, their functionality, and Java equivalents.


// 1. Arithmetic Operators
val a = 10
val b = 3

println(a + b) // Addition -> Java: a + b
println(a - b) // Subtraction -> Java: a - b
println(a * b) // Multiplication -> Java: a * b
println(a / b) // Division (Integer division if both are Int) -> Java: a / b
println(a % b) // Modulus (remainder) -> Java: a % b

val c = 10.0
println(c / b) // Floating-point division if one operand is Double -> Java: c / b


// 2. Bitwise Operators (Unlike Java's &, |, ^, ~, Kotlin uses functions)
val x = 5 // 0101 in binary
val y = 3 // 0011 in binary

println(x and y) // Bitwise AND -> Java: x & y  (Result: 0001 -> 1)
println(x or y)  // Bitwise OR  -> Java: x | y  (Result: 0111 -> 7)
println(x xor y) // Bitwise XOR -> Java: x ^ y  (Result: 0110 -> 6)
println(x.inv()) // Bitwise NOT -> Java: ~x (Inverts all bits, equivalent to -(x + 1))

println(x shl 1) // Bitwise Shift Left  -> Java: x << 1 (Shifts bits left by 1 position)
println(x shr 1) // Bitwise Shift Right -> Java: x >> 1 (Shifts bits right by 1 position)
println(x ushr 1) // Unsigned Shift Right -> Java: x >>> 1 (Only in Kotlin for unsigned shifts)


// 3. Comparison Operators
println(a == b) // Equality check -> Java: a == b
println(a != b) // Not equal      -> Java: a != b
println(a > b)  // Greater than   -> Java: a > b
println(a < b)  // Less than      -> Java: a < b
println(a >= b) // Greater or equal -> Java: a >= b
println(a <= b) // Less or equal    -> Java: a <= b


// 4. Assignment Operators
var num = 5
num += 3 // Equivalent to num = num + 3 -> Java: num += 3
num -= 2 // Equivalent to num = num - 2 -> Java: num -= 2
num *= 4 // Equivalent to num = num * 4 -> Java: num *= 4
num /= 2 // Equivalent to num = num / 2 -> Java: num /= 2
num %= 3 // Equivalent to num = num % 3 -> Java: num %= 3


// 5. Increment and Decrement Operators
var value = 10
println(value++) // Post-increment -> Java: value++
println(++value) // Pre-increment  -> Java: ++value
println(value--) // Post-decrement -> Java: value--
println(--value) // Pre-decrement  -> Java: --value


// 6. Logical Operators
val bool1 = true
val bool2 = false

println(bool1 && bool2) // Logical AND -> Java: bool1 && bool2
println(bool1 || bool2) // Logical OR  -> Java: bool1 || bool2
println(!bool1)         // Logical NOT -> Java: !bool1


// 7. Range Operator
println(5 in 1..10)  // Checks if 5 is in range [1, 10] -> No direct Java equivalent (use (x >= 1 && x <= 10))
println(5 !in 1..4)  // Checks if 5 is NOT in range [1, 4]


// 8. Elvis Operator (null safety)
var nullable: String? = null
println(nullable?.length ?: "Default") // If nullable is null, return "Default" -> Java equivalent: (nullable != null ? nullable.length() : "Default")


// 9. Safe Call and Non-null Assertion Operators
println(nullable?.length)  // Safe call (Returns null if nullable is null) -> Java: (nullable != null ? nullable.length() : null)
println(nullable!!.length) // Non-null assertion (Throws exception if nullable is null) -> Java: nullable.length()


// 10. Type Check and Cast Operators
val obj: Any = "Kotlin"

if (obj is String) { // Type check -> Java: if (obj instanceof String)
    println(obj.length) // Smart cast in Kotlin, no need for explicit cast
}

val number: Any = 10
val casted: Int? = number as? Int // Safe cast -> Java: (number instanceof Integer) ? (Integer) number : null


// Summary:
// - Arithmetic operators work similarly to Java.
// - Bitwise operations use functions instead of symbols (&, |, ^).
// - "==" checks value equality, "===" checks reference equality (like Java's == for objects).
// - Safe calls (?.) and the Elvis operator (?:) improve null handling in Kotlin.
// - Kotlin's type checks and safe casts provide better safety than Java.
