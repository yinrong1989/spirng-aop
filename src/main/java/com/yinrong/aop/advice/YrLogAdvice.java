package com.yinrong.aop.advice;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.yinrong.aop.annotation.YrLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.*;


/**
 * @author yinrong
 * @className YrLogAdvice
 * @description ${description}
 * @date 2017/3/10
 */
@Aspect
public class YrLogAdvice {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(com.yinrong.aop.annotation.YrLog)")
    public void YrLog() {
    }
    @Around("YrLog()")
    public void aroundCacheResult(ProceedingJoinPoint pjp) throws Throwable {
        Method method=getCurrentMethod(pjp);
        Annotation annotation=getMethodAnnotation(method, YrLog.class);
        YrLog yrLog=  (YrLog)annotation;
        System.out.println(pjp.getTarget().getClass());
        log.warn("class:{},method:{}",pjp.getTarget().getClass().toString(),method.getName());
        log.info(pjp.getArgs().toString());
        Long currentTime=System.currentTimeMillis();
        pjp.proceed();
        Long endTime=System.currentTimeMillis();
        System.out.println("耗时"+(endTime-currentTime));
    }

    private Annotation getMethodAnnotation(Method method, Class annotationClass) {
        if (annotationClass!=null){
        Annotation annotation=method.getAnnotation(annotationClass);
        if (annotation!=null){
            return  annotation;
        }else{
            throw new NullPointerException("获取annotation失败");
        }
        }else{
            throw new NullPointerException("method不能为空");
        }
    }

    protected Method getCurrentMethod(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature=pjp.getSignature();
        MethodSignature methodSignature=null;
        if (!(signature instanceof MethodSignature)){
          throw new IllegalArgumentException("改注解只能用于方法");
        }
        methodSignature= (MethodSignature) signature;
        Method method=pjp.getTarget().getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
        return  method;
    }
}
