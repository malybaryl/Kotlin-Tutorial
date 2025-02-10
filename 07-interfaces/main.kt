import person.Person3

// An interface in Kotlin defines a contract that classes can implement.
// It can contain abstract methods (without implementation) and default methods (with implementation).
// Unlike abstract classes, interfaces cannot store state (no instance fields).
// A class can implement multiple interfaces, allowing for flexible design.

//! WE DON'T NEED ONE FILE FOR CLASS OR INTERFACE IN KOTLIN LIKE JAVA

interface InfoPersonProvider {
    //! var providerInfo: String = "Default" | error: we can't initialize var in interface
    val providerInfo: String

    fun printInfo(person: Person3){
        println(providerInfo)
        person.printInfo()
    }
}


// An abstract class in Kotlin serves as a base class that cannot be instantiated directly.
// It can have both abstract (without implementation) and concrete (with implementation) methods.
// Unlike interfaces, an abstract class can store state using properties with backing fields.
// A class can inherit from only one abstract class due to Kotlin's single inheritance model.

abstract class BasicInfoProviderAbstract: InfoPersonProvider 

class BasicInfoProvider: InfoPersonProvider {
    override fun printInfo(person: Person3) {
        println("printing additional info")
        person.printInfo()
    }

    override val providerInfo: String
        get() = "Basic info provider"
    
}

class BasicInfoProvider2: InfoPersonProvider {
    override val providerInfo: String
        get() = "Basic info provider 2"
}

// Adding multiple interfaces
interface SessionInfoProvider{
    fun getSessionId(): String
}

class BasicInfoProvider3: InfoPersonProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic info provider 3"

    override fun printInfo(person: Person3) {
        super.printInfo(person)
        println("printing additional sentence")
    }

    override fun getSessionId(): String {
        return "session id"
    }
}


fun main() {
    val provider = BasicInfoProvider()
    val provider2 = BasicInfoProvider2()
    val provider3 = BasicInfoProvider3()
    println("\n---------\n")

    provider.printInfo(Person3())
    println("\n---------\n")

    provider2.printInfo(Person3())
    println("\n---------\n")

    provider3.printInfo(Person3())
    provider3.getSessionId()

    checkTypes(provider)
    checkTypes(provider2)
    checkTypes(provider3)

    println("\n---------\n")

    negativeCheckTypes(provider)
    negativeCheckTypes(provider2)
    negativeCheckTypes(provider3)
}

fun checkTypes(infoProvider: InfoPersonProvider){
    if(infoProvider is BasicInfoProvider){
        println("is BasicInfoProvider")
    } else {
        println("is not BasicInfoProvider")
    }
}

fun negativeCheckTypes(infoProvider: InfoPersonProvider){
    if(infoProvider !is BasicInfoProvider){
        println("is BasicInfoProvider")
    } else {
        println("is not BasicInfoProvider")
        (infoProvider as BasicInfoProvider).printInfo(Person3())
        // we don't need to cast
        infoProvider.printInfo(Person3())
    }
}