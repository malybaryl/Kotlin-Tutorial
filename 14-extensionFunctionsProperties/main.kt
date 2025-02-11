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

    data class Easy(val id: String, val name: String): Entity()
    
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, var multiplier: Float): Entity() {
        
        override fun equals (other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }

}

// Extension function
fun Entity.Medium.printInfo(){
    println("Medium class $id")
}

// Extension Methods
val Entity.Medium.info: String get() = "Medium class $id" //! You need to use 'get' keyword

fun main(){
    Entity.Medium("id", "name").printInfo()
    // Smart Casting
    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    if (entity2 is Entity.Medium){
        entity2.printInfo()
        println(entity2.info)
    }
}