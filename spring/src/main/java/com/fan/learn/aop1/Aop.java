/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:18
 */
package com.fan.learn.aop1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before("execution(* com.fan.learn.aop1..*.*(..))")
    public void begin() {
        System.out.println("开始事务");
    }

    @After("execution(* com.fan.learn.aop1..*.*(..))")
    public void close() {
        System.out.println("关闭事务");
    }
}
