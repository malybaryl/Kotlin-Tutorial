fun getGreeting(): String {
    return "Hello, there!"
}

//* Unit is the return type (void)

// Unit and Nothing in Kotlin:
//
// Unit - Represents the absence of a meaningful value, similar to void in Java.
//        A function with Unit returns normally but does not provide a useful result.
//
// Nothing - Represents a function that never returns (e.g., always throws an exception or enters an infinite loop).
//           This type is used to indicate unreachable code or error handling scenarios.
fun sayHello(name: String): Unit {
    //! return "Hello, $name!"  // error because return type is Unit (void) cant return String
    println("Hello, $name!")
}
fun crash(): Nothing {
    throw Exception("Something went wrong")
}

val hello: () -> Unit = { println("Hello") }

// unit is the default return type
fun sayHello2(name: String){
    println("Hello, $name!")
}

// enable returning null
fun sayHello3(name: String): String? {
    return null
}

// sigle expression functions
fun sayHello4(): Unit = println("Hello, Kotlin!")
// The compiler knows the return type so you can omit it
fun sayHello5() = println("Hello, Kotlin!")

// functions parameters
fun sayHello7 (itemToGreet: String) {
    println("Hello, " + itemToGreet)
}

fun sayHello8 (itemToGreet: String) {
    println("Hello, $itemToGreet!")
}

fun sayHello9 (greeting: String, itemToGreet: String) {
    println("$greeting, $itemToGreet!")
}


fun main(){
    println("Hello, World!")
    println(getGreeting())
    sayHello("John")
    //! crash()
    hello()
    sayHello2("Jack")

    sayHello7("World")
    sayHello9("Nice to meet you", "John")
}

