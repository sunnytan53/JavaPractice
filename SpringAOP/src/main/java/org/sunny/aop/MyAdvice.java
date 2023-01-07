package org.sunny.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    // @Before("point()")
    // public void before() {
    //     System.out.println("\texecute before point");
    // }

    // @After("point()")
    // public void after() {
    //     System.out.println("\texecute after point");
    // }

    @Around("point()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("\texecute before point in around");
        // we have to specify when to call the target method
        // we also have to throw exception that occurs in the target method
        Object proceed = pjp.proceed();
        System.out.println("\texecute after point in around");
        return proceed;
    }

    // @AfterReturning and @AfterThrowing is obvious as their name
}
