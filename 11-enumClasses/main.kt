import java.util.*

enum class EntityType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().replaceFirstChar { it.uppercase() } // Formatting
}


object EntityFactory {
    fun create(type: EntityType): Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.name // we can also use EntityType.EASY.name // EASY
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return Entity(id, name)
    }
}

class Entity(val id: String, val name: String){
    override fun toString(): String {
        return "Entity $name (id=$id)"
    }
}

fun main(){
    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)

    val easyEntity = EntityFactory.create(EntityType.EASY)
    println(easyEntity)
}