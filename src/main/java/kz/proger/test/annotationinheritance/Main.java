package kz.proger.test.annotationinheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext("kz.proger.test.annotationinheritance");
        AbstractParent bean = appCtx.getBean(ChildBean.class);
        System.out.println(bean);
    }
}
