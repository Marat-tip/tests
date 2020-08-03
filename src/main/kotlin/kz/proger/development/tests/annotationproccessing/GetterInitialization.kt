package kz.proger.development.tests.annotationproccessing

class GetterInitialization : HasName

fun main() {
    val nameHolder = GetterInitialization()
    println(nameHolder.name)
    println(nameHolder.name)
}

interface HasName {
    val name: String
        get() {
            println("getting name")
            return getName()
        }
}

fun getName() = "Name"

