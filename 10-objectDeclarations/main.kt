object EntityFactory {
    fun create() = Entity(123)
}

class Entity(val id: Int){
    override fun toString(): String {
        return "Entity(id=$id)"
    }
}

fun main(){
    val entity = EntityFactory.create()
}