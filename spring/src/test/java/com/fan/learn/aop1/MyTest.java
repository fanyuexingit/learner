/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 16:36
 */
package com.fan.learn.aop1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanyuexin on 2021/02/08
 */
public class MyTest {

    //有接口 使用动态代理
    @Test
    public void test0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop1.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDaoImpl");
        userDao.save();
        System.out.println(userDao.getClass());
    }
    //没有接口 使用cglib代理
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop1.xml");
        OrderDaoImpl orderDaoImpl = (OrderDaoImpl)applicationContext.getBean("orderDaoImpl");
        orderDaoImpl.save();
        System.out.println(orderDaoImpl.getClass());
    }
}
