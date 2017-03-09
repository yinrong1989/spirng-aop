package com.yinrong.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author yinrong
 * @className StudentAdvice
 * @description ${description}
 * @date 2017/3/9
 */
@Aspect
public class StudentAdvice {
    @Before("execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))")
    public void validateUser(JoinPoint pjp) throws Throwable {
        System.out.println("执行用户验证");
    }

    @Before("execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))")
    public void beginTransaction(JoinPoint pjp) throws Throwable {
        System.out.println("开始事物");
    }

    @After("execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))")
    public void endTransaction() throws Throwable {
        System.out.println("结束事务");
    }

    @After("execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))")
    public void writeLogInfo() {

        System.out.println("记录日志信息");

    }

    @AfterThrowing(pointcut = "execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))", throwing = "ex")
    // 声明异常，StudentMgr类的update方法出现异常时执行
    public void printException(Exception ex) {

        System.out.println("执行update方法时发生错误" + ex.getMessage());

    }
    @Around("execution (* com.yinrong.components.impl.StudentsManageImpl.update*(..))")
    // 声明环绕通知，拦截StudentMgr的所有以update开头的方法
    public Object doSurround(ProceedingJoinPoint _pjp) throws Throwable {

        // 如果需要对连接点传入的参数进行处理，可以通过代码获取：pjp.getArgs();

        Object result;

        if (true) {

            // 这里可以根据条件决定是否进入这个if

            System.out.println("进入环绕通知...");

            result = _pjp.proceed();// 使用环绕通知时，这个方法必须要执行，否则被拦截的方法就不会再执行了

            System.out.println("退出环绕通知...");

        }

        // 返回执行后的返回值

        return result;

    }


    public static void main(String[] args) {

    }
}
