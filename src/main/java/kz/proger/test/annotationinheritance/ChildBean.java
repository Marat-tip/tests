package kz.proger.test.annotationinheritance;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ChildBean extends AbstractParent {
    @PostConstruct
    public void init() {
        System.out.println(someStr);
    }
}
