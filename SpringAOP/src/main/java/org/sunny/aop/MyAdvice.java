package org.sunny.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    // it is better to specify the method from an interface
    // * means match exactly *1* any layer
    // .. means match any amount of layers (including 0) BUT slow
    // + means match the child class of the specified class
    @Pointcut("execution(void org.sunny.dao.BookInterface.*e())")
    private void point() {  // this means where to execute, like a link
        // Nothing will execute in this coding block
    }

    @Before("point()")
    public void method() {  // this is the exact method to run
        System.out.println("\texecute before point");
    }
}
