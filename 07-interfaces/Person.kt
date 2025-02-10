package person

// In Kotlin visiblity for classes, methods, and properties is public by default

public class examplePublcClass {}
// it is public by default so we don't need to add public and we can access it from anywhere

final internal class exampleInternalClass {}
// In Kotlin, classes and methods are 'final' by default, meaning they cannot be inherited or overridden.
// This property/function/class is marked as 'internal', 
// meaning it is accessible only within the same module.
// It is not visible outside the module boundary.

open class exampleProtectedClass  {
    protected var greeting: String = "Hello"
}
// The 'open' keyword allows a class to be inherited or a method/property to be overridden in a subclass.
// This property/function is marked as 'protected', 
// meaning it is accessible within the same class and its subclasses.
// It is not visible outside the class hierarchy.

private class examplePrivateClass {}
// This property/function/class is marked as 'private', 
// meaning it is accessible only within the same class.
// It is not visible outside the class.

/*
| Modifier   | Class Members Visibility               | Top-Level Declarations Visibility |
|------------|----------------------------------------|-----------------------------------|
| public     | Visible everywhere                     | Visible everywhere                |
| internal   | Visible within the same module         | Visible within the same module    |
| protected  | Visible in the same class & subclasses | N/A (not allowed)                 |
| private    | Visible within the same class          | Visible within the same file      |
*/


// You even can create empty classes without { }
// We can do default constructor by using key word constructor
class EmptyClass constructor()

// default constructor we can do like this:
class Person (_firstName: String, _lastName: String) {
    val firstName: String 
    val lastName: String 

    init {   // init block (initialization block) is run 
            // every time a new instance of the class is created
            // and you can have MULTIPLE init blocks
        firstName = _firstName
        lastName = _lastName
    }

    // Other way to initialize variables

    val firstName2: String = _firstName
    val lastName2: String = _lastName
}

// We don't need to assain values to variables, we can do it in constructor
class Person2(val firstName: String, val lastName: String){

    init {
        println("init 1")
    }

    // Secondery constructor
    constructor() : this("Peter", "Parker") {
        println("Secondary constructor called")
    }

    // init block will run always before constructor
    init {
        println("init 2")
    }
}

// We don't need to do secondary constructor, we can do it in constructor
class Person3(val firstName: String = "John", val lastName: String = "Doe") {
    var nickname: String? = null
    // override setters and getters
        set(value){ // We need to assain value to field and do it below the field
            field = value
            println("Nickname changed to $value")
        }
        get()
        {
            println("return value is: $field")
            return field
        }

    // Adding methods
    fun printInfo(){
        val nicknameToPrint = if(nickname != null) nickname else "no nickname"
        println("First name: $firstName | Last name: $lastName | Nickname: $nicknameToPrint")

        // or use ELVIS operator
        // if left side of ?: is not null, it returns the left side, otherwise it returns the right side
        val nicknameToPrint2 = nickname ?: "no nickname"
        println("First name: $firstName | Last name: $lastName | Nickname: $nicknameToPrint2")

    }
}
