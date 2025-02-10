//? Commend to run this: kotlinc main.kt Person.kt -include-runtime -d output.jar && java -jar 

import person.EmptyClass
import person.Person
import person.Person2
import person.Person3

fun main() {
    // in Kotlin we don't need to instantiate a class (new keyword)
    val emptyClass = EmptyClass()
    val person = Person("John", "Doe")

    println(person.firstName) // We don't have to use getters
    println(person.lastName) // it's called PROPERTY ACCESS SYNTAX

    println("\n---------\n")

    val person2 = Person2("John", "Doe")
    println(person2.firstName)
    println(person2.lastName)

    val person3 = Person2()
    
    println("\n---------\n")

    val person4 = Person3()
    println(person4.firstName)
    println(person4.lastName)

    person4.nickname = "jonnyd"

    println(person4.nickname)

    println("\n---------\n")

    person4.printInfo()

    val person5 = Person3("Jane", "Smith")

    person5.printInfo()
}
