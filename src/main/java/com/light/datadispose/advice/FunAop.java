package com.light.datadispose.advice;


import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FunAop {
    @Autowired
    Set<String> funset;
    @Pointcut("execution (* com.light.datadispose.service..IFunService+.*(..))")
    public void funaop(){

    }

    @Before("funaop()")
    public void addTask(JoinPoint jp){
        String flat=jp.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        flat+="."+method.getName();
        log.info("添加任务方法:"+flat);
        funset.add(flat);
    }
    @After("funaop()")
    public void removeTask(JoinPoint jp){
        String flat=jp.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        flat+="."+method.getName();
        log.info("完成任务方法:"+flat);
        funset.remove(flat);

    }
}
