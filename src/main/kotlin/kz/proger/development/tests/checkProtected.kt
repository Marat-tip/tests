package kz.proger.development.tests

abstract class Parent {
    fun publicMethod() {
        println("Hello from Parent")
    }

    protected abstract fun protectedMethod()
}

class Child(val delegate: Parent) : Parent() {
    override fun protectedMethod() {
    }

}