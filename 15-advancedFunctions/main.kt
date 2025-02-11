fun printFilteredString(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach{
        if (predicate(it)) {
            println(it)
        }
    }
}

fun printFilteredString2(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach{
        //! if (predicate(it)) { //! Error // we need to use invoke
        //!     println(it)
        //! }

        // In Kotlin, the "invoke" operator allows an instance of a class to be called like a function.
        // This is done by defining an "invoke" function inside a class.

        // Summary:
        // - "invoke" makes an object callable like a function.
        // - It improves code readability and can be useful for functional programming.

        if (predicate?.invoke(it) == true) {
            println(it)
        }


    }
}

val predcate: (String) -> Boolean = {
    it.startsWith("a")
}

fun getPrintPredicate(): (String) -> Boolean {
    return {
        it.startsWith("o")
    }
}

fun main(){
    println("\n---------\n")
    
    val list = listOf("apple", "banana", "orange")
    printFilteredString(list) { 
        it.startsWith("b") 
    }
    
    println("\n---------\n")

    printFilteredString2(list, null)
    
    println("\n---------\n")

    printFilteredString2(list, predcate)

    println("\n---------\n")

    printFilteredString2(list, getPrintPredicate())

}