package person

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
        set(value){ // We need to assain value to field and do it below the field
            field = value
            println("Nickname changed to $value")
        }

    // override setters and getters
}
