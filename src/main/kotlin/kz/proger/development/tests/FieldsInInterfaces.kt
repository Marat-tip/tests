package kz.proger.development.tests


interface IWithField {
    val hello: String
        get() {
            println("Called hello")
            return "Hello"
        }
}

class WithField : IWithField

fun main() {
    val withField = WithField()
    println(withField.hello)
    println(withField.hello)
}
