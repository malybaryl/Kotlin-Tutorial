object EntityFactory {
    fun create() = Entity(123)
}

class Entity(val id: Int){
    
}

fun main(){
    val entity = EntityFactory.create()
}