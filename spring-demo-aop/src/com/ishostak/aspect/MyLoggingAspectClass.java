package com.ishostak.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspectClass {

    //added all of our related advices

    @Before("execution(public void com.ishostak.aopdemo.dao.AccountDAO())")
    public void beforeAddAccount() {
        System.out.println("\n======> @Before advice on addAccount");
    }
}
