// Wy can make variables outside of functions

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