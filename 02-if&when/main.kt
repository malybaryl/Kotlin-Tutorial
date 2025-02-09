var name: String? = "John"
var greeding: String? = "Hello"

fun main(){
    if (name != null) {
        println(name)
    }

    name = null

    if (name != null) {
        println(name)
    } else {
        println("Hi!")
    }

    // When 
    greeding = null

    when (greeding) {
        null -> println("Hi!")
        else -> println(greeding)
    }

    greeding = "Hello"

    when (greeding) {
        null -> println("Hi!")
        else -> println(greeding)
    }

    // Assaining a value to a variable
    var greetingToPrint = if (greeding != null) greeding else "Hi!"
    println(greetingToPrint)

    greeding = "Instead"
    greetingToPrint = if (greeding != null) greeding else "Hi!"
    println(greetingToPrint)

    // We can also use when to assign a value to a variable
    val greetingToPrint2 = when(greeding) {
        null -> "Hi!"
        else -> greeding
    }
    println(greetingToPrint2)

    greeding = null
    val greetingToPrint3 = when(greeding) {
        null -> "Hi!"
        else -> greeding
    }
    println(greetingToPrint3)
}