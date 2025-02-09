fun main(){
    //* Lists can be created using listOf()
    // In Kotlin, lists (List and Array) are generic, meaning they store elements of a specific type.
    // This ensures type safety and prevents accidental type mismatches.

    val numbers: List<Int> = listOf(1, 2, 3, 4) // A list of integers
    val words: List<String> = listOf("Hello", "World") // A list of strings

    // If we want to store elements of different types in a single list, we can use Any as the common supertype.
    // The Any type is the root of Kotlin's type hierarchy, allowing us to mix different data types.

    val mixedList: List<Any> = listOf(1, "Hello", 3.14, true)

    // However, using Any comes with some drawbacks:
    // - We lose type safety, meaning we need to manually cast values before using them.
    // - Processing elements becomes more complex because we must check their types explicitly.

    val intrestingThings = listOf("Kotlin", "Programming", "Android")

    println(intrestingThings.size)
    println(intrestingThings[0])
    println(intrestingThings.get(0))

    println("\n---------\n")

    // Iterating over a list
    for (inrestedThing in intrestingThings) {
        println(inrestedThing)
    }

    println("\n---------\n")

    intrestingThings.forEach {
        println(it) //? it - the default parameter name which is the current element
    }

    println("\n---------\n")

    intrestingThings.forEach { intrestedThing ->    //* Changing the default parameter name
        println(intrestedThing)
    }

    //? Why we write forEach without ()?
    // It is cause it is a lambda expression

    println("\n---------\n")

    // Iterating with index
    intrestingThings.forEachIndexed { index, intrestedThing ->
        println("Item at $index is $intrestedThing")
    }


    println("\n---------\n")

    // LIST

    val list = listOf("a", "b", "c", "d", "e")
    println(list[0])
    println(list.get(0))

    intrestingThings.forEach { intrestedThing ->
        println("$intrestedThing")
    }

    println("\n---------\n")

    val mutableList = mutableListOf("a", "b", "c", "d", "e")
    mutableList.add("f")
    mutableList.removeAt(0)
    mutableList.forEach { intrestedThing ->
        println("$intrestedThing")
    }

    // ARRAY VS LIST
    // Key Differences:
    // ----------------------------------------------------------------------------------------
    // | Feature         | Array                        | List (Immutable)   | MutableList     |
    // ----------------------------------------------------------------------------------------
    // | Size           | Fixed                        | Dynamic            | Dynamic         |
    // | Modification   | Allowed (elements only)     | Not allowed        | Allowed         |
    // | Performance    | Fast access (indexed)       | Fast access        | Slightly slower |
    // | Resizing      | Not possible                 | Not possible       | Possible        |
    // ----------------------------------------------------------------------------------------

    // Maps

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map["a"])

    println("\n---------\n")

    map.forEach { (key, value) ->
        println("$key -> $value")
    }

    val mutableMap = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    mutableMap["d"] = 4
    mutableMap.remove("a")
    mutableMap.forEach { (key, value) ->
        println("$key -> $value")
    }

    println("\n---------\n")

    fun hello(greeting: String, target: List<String>) {
        target.forEach { name ->
            println("$greeting, $name!")
        }
    }

    hello("Hello", intrestingThings)
}