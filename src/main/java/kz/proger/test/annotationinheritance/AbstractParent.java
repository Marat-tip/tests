package kz.proger.test.annotationinheritance;

import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractParent {
    @Autowired
    protected String someStr;
}
