package kz.proger.development.tests.annotationcontext

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation


class LoggingDelegate : ReadOnlyProperty<InterceptionOfDelegateDemo, String> {
    override fun getValue(thisRef: InterceptionOfDelegateDemo, property: KProperty<*>): String {
        if (property.findAnnotation<LoggableProperty>() != null) {
            println("setting value for ${property.name}")
        }
        return "new value ${System.currentTimeMillis()}"
    }
}

class InterceptionOfDelegateDemo {
    val lateInit by LoggingDelegate()

    @LoggableProperty
    val loggableLateInit by LoggingDelegate()
}

fun main() {
    println(InterceptionOfDelegateDemo().lateInit)
    println(InterceptionOfDelegateDemo().loggableLateInit)
}

annotation class LoggableProperty