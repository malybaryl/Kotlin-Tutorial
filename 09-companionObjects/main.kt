// A "companion object" in Kotlin is a special object that belongs to a class 
// but behaves like a static member in Java. It allows defining properties 
// and functions that are shared among all instances of the class.

// The companion object is declared inside a class using the "companion" keyword.
// It can contain methods, constants, or even implement interfaces.


class Entity private constructor(val id: Int) {

    companion object: IdProvider {
        override fun getId(): Int {
            return 123
        }

        fun create() = Entity(getId())
    }
    //! CAN BY ONE COMANION OBJECT FOR CLASS
    
}

class Entity2 private constructor(val id: Int) {

    
    // You can change name of companion object
    companion object EntityFactory {
        // In Kotlin, "const val" and "val" are both used to declare read-only variables,
        // but they have different behaviors and use cases.

        // 1. "const val" (Compile-time constant)
        // - Can only be used at the top level or inside an "object" or "companion object".
        // - The value must be known at compile time.
        // - Only supports primitive types (Int, String, Double, etc.).
        // - Cannot be assigned to a function result or runtime evaluation.
        // - Improves performance because the compiler replaces occurrences of "const val" 
        //   with its actual value.
        // 2. "val" (Runtime constant)
        // - Used for read-only variables, but the value can be set at runtime.
        // - Can store results of functions or dynamic calculations.
        // - Can be used inside classes.
        // - More flexible than "const val", but does not provide compile-time optimizations.
        // Summary:
        // - Use "const val" for fixed values that do not change and are known at compile time.
        // - Use "val" for read-only variables that might need runtime evaluation.
        const val id = 200
       
     
        
        fun create() = Entity2(id)

    }
    
}

interface IdProvider {
    fun getId(): Int
}

fun main(){
    val entity = Entity.Companion.create()
    // we can short this to:
    val entity2 = Entity.create()

    val entity3 = Entity2.EntityFactory.create()
}