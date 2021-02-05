package com.ishostak.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspectClass {

    // .. in params means from 0 to more any params
    // * means anything

    /*
      @Before("execution(* add* com.ishostak.aopdemo.dao.*.*(..))")
      matches any class, any method in package
     */

    @Before("execution(* add* (com.ishostak.aopdemo.dao.Account, ..))")
    public void beforeAddAccount() {
        System.out.println("\n======> @Before advice on addAccount");
    }
}
