/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:18
 */
package com.fan.learn.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/03
 */
@Component
@Aspect
public class Aop {

//    1、execution(): 表达式主体。
//    2、第一个*号：表示返回类型，*号表示所有的类型。
//    3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
//    4、第二个*号：表示类名，*号表示所有的类。
//    5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。

//    @Before("execution(* com.fan.learn.aop1..*.*(..))")
//    public void begin() {
//        System.out.println("开始事务");
//    }
//
//    @After("execution(* com.fan.learn.aop1..*.*(..))")
//    public void close() {
//        System.out.println("关闭事务");
//    }



    // 指定切入点表达式，拦截哪个类的哪些方法
    @Pointcut("execution(* com.fan.learn.aop1..*.*(..))")
    public void pt() {

    }




    // 前置通知 : 在执行目标方法之前执行
    @Before(value = "pt()")
    public void begin(){
        System.out.println("开始事务");
    }

    // 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
    @After("pt()")
    public void after(){
        System.out.println("关闭事务");
    }

    // 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    // 异常通知： 当目标方法执行异常时候执行此关注点代码
    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("afterThrowing()");
    }

    // 环绕通知：环绕目标方式执行
    @Around("pt()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕前....");
        pjp.proceed();  // 执行目标方法
        System.out.println("环绕后....");
    }
}
