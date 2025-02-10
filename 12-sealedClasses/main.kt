import java.util.*


enum class EntityType {
    HELP ,EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().replaceFirstChar { it.uppercase() } // Formatting
}


object EntityFactory {
    fun create(type: EntityType): Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.HELP -> "Help"
            EntityType.EASY -> type.name // we can also use EntityType.EASY.name // EASY
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

// In Kotlin, a "sealed class" is a special type of class that restricts inheritance.
// It acts as an abstract class but ensures that all possible subclasses are known at compile-time.
// This makes sealed classes useful for representing state, handling results, and event-driven architectures.

// Key Features:
// 1. All subclasses must be declared in the same file as the sealed class.
// 2. Unlike enums, sealed classes allow subclasses with different properties and behaviors.
// 3. When used in "when" expressions, sealed classes ensure exhaustive checks at compile-time.
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
    data class Hard(val id: String, val name: String, var multiplier: Float): Entity()
}

fun main(){
    val mediumEntity:Entity = EntityFactory.create(EntityType.MEDIUM)
    val msg = when(mediumEntity){
        Entity.Help -> "Help" // we need to use "is" keyword because it's static
        is Entity.Easy -> "easy"
        is Entity.Medium -> "medium"
        is Entity.Hard -> "hard"
    }
    println(msg)
}