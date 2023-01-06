package org.sunny.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void org.sunny.dao.Book.update())")
    private void point() {  // this means where to execute, like a link
        // Nothing will execute
    }

    @Before("point()")
    public void method() {  // this is the exact method to run
        System.out.println("\texecute before point");
    }
}
