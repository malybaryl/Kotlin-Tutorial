// vararg 

/**
 * In Kotlin, `vararg` is used to pass a variable number of arguments to a function.
 * It allows a function to accept multiple arguments of the same type without explicitly defining them one by one.
 * 
 * - Only one `vararg` parameter is allowed per function.
 * - If there are other parameters, the `vararg` must be the last parameter or followed by named parameters.
 * - Internally, Kotlin treats `vararg` as an array of the specified type.
 * - You can pass an existing array using the spread operator (`*`).
 */

fun hello(greeting: String, vararg target: String) {
    target.forEach { name ->
        println("$greeting, $name!")
    }
}

fun main(){
    hello("hello") // now we don't need to pass an array
    hello("Hello", "Kotlin", "World", "John", "Jane")

    println("\n---------\n")

    var intrestedThing = arrayOf("Kotlin", "Programming", "Android")
    //! hello("Hello", intrestedThing) //! error : vararg must be the last parameter

    hello("Hello", *intrestedThing) //* spread operator
    /**
     * The spread operator (`*`) in Kotlin is used to pass an array as a `vararg` parameter.
     * It unpacks the array elements and treats them as separate arguments.
     */

    // ---
    println("\n---------\n")

    // named arguments
    /**
     * Named arguments in Kotlin allow you to specify function parameters by name instead of position.
     * This improves readability and avoids confusion with multiple parameters of the same type.
     */

    hello( target = *intrestedThing, greeting = "Hello")

    // ---
    println("\n---------\n")

    // default parameter values
    /**
     * Default parameter values in Kotlin allow you to specify default values for function parameters.
     * If a parameter is not provided, the default value will be used instead.
     */

    fun hello2(greeting: String = "Hello", target: String = "Kotlin") {
        println("$greeting, $target!")
    }

    hello2()
    hello2(target = "World")
    hello2(greeting = "Hello", target = "World")

    //! YOU CAN'T MIX NAMED AND POSITIONAL ARGUMENTS
    //! hello2(greeting = "Hello", "World") //! error

    

}