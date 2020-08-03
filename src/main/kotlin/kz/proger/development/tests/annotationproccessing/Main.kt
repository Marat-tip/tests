package kz.proger.development.tests.annotationproccessing

fun main() {
    val someClass = SomeClass()
    someClass.someFun()
    (someClass as One).someFun()
}

class SomeClass : One,
    Two {
    override fun someFun() {
        println("someFun from SomeClass")
    }
}

interface One {
    fun someFun();
}

interface Two {
    fun someFun() = println("some fun from Two")
}