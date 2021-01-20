package com.ishostak.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //enable proxy for aop
@ComponentScan("com.ishostak")
public class DemoConfig {

}
