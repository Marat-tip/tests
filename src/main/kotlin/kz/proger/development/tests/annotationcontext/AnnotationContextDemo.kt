package kz.proger.development.tests.annotationcontext

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class AnnotationContextDemo

fun main() {
    val appCtx = AnnotationConfigApplicationContext(MainConfig::class.java)
    val bean = appCtx.getBean(String::class.java)
    println(bean)
}

@Configuration
class MainConfig {
    @Bean
    fun getApplicationName() = "Hello f*cking world"
}