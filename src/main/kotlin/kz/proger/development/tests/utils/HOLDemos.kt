package kz.proger.development.tests.utils

fun main() {
    val intList = (0..10)
    intList.windowed(4).onEach { println(it.toString()) }
    intList.chunked(4) { println(it.sum()) }
}