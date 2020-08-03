package kz.proger.test.annotationinheritance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringBeansConfiguration {
    @Bean
    public String somStr() {
        return "SomeStr";
    }
}
