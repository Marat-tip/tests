package kz.proger.test;

import kz.proger.test.annotationinheritance.AnotherChild;
import kz.proger.test.annotationinheritance.UtilityClass;

public class Main {
    public static void main(String[] args) {
        AnotherChild anotherChild = new AnotherChild();
        UtilityClass utilityClass = new UtilityClass();
        utilityClass.doSmthToParent(anotherChild);
    }

    public <T extends CharSequence> void saySmth(T arg) {
        System.out.println(arg.toString());
    }
}
