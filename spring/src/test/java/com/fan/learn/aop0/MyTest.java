/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 15:19
 */
package com.fan.learn.aop0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanyuexin on 2021/02/08
 */
public class MyTest {

    //静态代理 有接口
    @Test
    public void test0(){
        UserDao userDao = new UserDaoImpl();
        UserStaticProxy userStaticProxy = new UserStaticProxy(userDao);
        userStaticProxy.save();
    }

    //静态代理 无接口
    @Test
    public void test00(){
        OrderStaticProxy orderStaticProxy = new OrderStaticProxy();
        orderStaticProxy.save();
    }

    //jdk动态代理
    @Test
    public void test1(){
        JDKDynamicProxy dynamicProxy = new JDKDynamicProxy();
        UserDao proxy = dynamicProxy.getProxy();
        proxy.save();
    }

    //cglib动态代理
    @Test
    public void test2(){
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDaoImpl proxyInstance = (UserDaoImpl)new CglibDynamicProxy(userDaoImpl).getProxyInstance();
        proxyInstance.save();
    }

    //工厂静态
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop0.xml");
        UserDao proxy = (UserDao)applicationContext.getBean("proxy");
        proxy.save();
    }

    //工厂非静态
    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop0.xml");
        UserDao proxy = (UserDao)applicationContext.getBean("userDao");
        proxy.save();
    }

}
