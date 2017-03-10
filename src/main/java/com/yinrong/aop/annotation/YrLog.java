package com.yinrong.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yinrong
 * @className log
 * @description ${description}
 * @date 2017/3/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface YrLog {
    String methodName()default "";
    String clzzName()default "";
    boolean shwoParamFlag() default true;
}
