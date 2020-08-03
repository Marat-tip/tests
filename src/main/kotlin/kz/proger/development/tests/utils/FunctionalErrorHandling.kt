package kz.proger.development.tests.utils

fun main() {
    println(runCatching {
        when (false) {
            true -> "true"
            else -> throw IllegalStateException()
        }
    }.getOrElse {
        println(it)
        "default"
    })
}
