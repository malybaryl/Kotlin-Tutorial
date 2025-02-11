import java.util.*


enum class EntityType {
    HELP ,EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().replaceFirstChar { it.uppercase() } 
}


object EntityFactory {
    fun create(type: EntityType): Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.HELP -> "Help"
            EntityType.EASY -> type.name 
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return when(type){
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2.0f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity(){
    object Help: Entity() {
        val name = "help"
    }
    // The "data" keyword in Kotlin is used to define a data class,
    // which is a special type of class optimized for storing data.
    // Data classes automatically generate useful methods such as:
    // - toString() -> Provides a readable string representation
    // - equals() -> Compares object values instead of references
    // - hashCode() -> Generates a hash code for collections
    // - copy() -> Creates a new instance with modified values
    // - componentN() -> Enables destructuring declarations
    // Summary:
    // - Data classes are ideal for storing and processing simple data.
    // - They reduce boilerplate by auto-generating common methods.
    // - Use them when you need immutable, structured data.
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, var multiplier: Float): Entity() {
        // We can override methods
        override fun equals (other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }
}

fun main(){
    val entity1 = EntityFactory.create(EntityType.EASY)
    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    val entity3 = EntityFactory.create(EntityType.HARD)
    val entity4 = EntityFactory.create(EntityType.EASY)

    if (entity1 == entity4){
        println("entity are equal")
    } else {
        println("entity are not equal") // will print not equal because the ids are different
    }
    
    println("\n---------\n")

    val entity5 = Entity.Easy("id", "name")
    val entity6 = Entity.Easy("id", "name")
    if (entity5 == entity6){
        println("entity are equal") // will print are equal 
    } else {
        println("entity are not equal")
    }

    // We can copy an object
    println("\n---------\n")

    val entity7 = entity5.copy()
    val entity8 = entity5.copy(name = "new name")

    if (entity7 == entity5){
        println("entity are equal") // will print are equal 
    } else {
        println("entity are not equal")
    }

    println("\n---------\n")

    if (entity7 === entity8){
        println("entity are equal") 
    } else {
        println("entity are not equal") // will print they are not equal 
    }

    println("\n---------\n")
    
    // In Kotlin, there are two types of equality checks: "==" and "===".

    // 1. "==" (Structural Equality)
    // This checks if two objects have the same content (value equality).
    // It internally calls the "equals()" method.

    // 2. "===" (Referential Equality)
    // This checks if two references point to the same memory location (object identity).

    // Summary:
    // - Use "==" to compare values (content).
    // - Use "===" to check if two references point to the exact same object.

    if (entity7 === entity8){
        println("entity are equal") 
    } else {
        println("entity are not equal") // will print they are not equal 
    }

    if (entity7 === entity5){
        println("entity are equal")  
    } else {
        println("entity are not equal") // if we change to === now is not equal
    }

}