package com.light.datadispose.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;

@Aspect
@Component
public class FunAop {
    @Autowired
    Set<String> funser;
    @Pointcut("execution (* com.light.datadispose.service..IFunService+.*(..))")
    public void funaop(){

    }

    @Before("funaop()")
    public void test(JoinPoint jp){
        System.out.println(jp.getTarget().getClass().getName());
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        throw new RuntimeException();

    }
}
