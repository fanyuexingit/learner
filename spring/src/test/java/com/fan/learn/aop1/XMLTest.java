/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 10:11
 */
package com.fan.learn.aop1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanyuexin on 2021/02/09
 */
public class XMLTest {

    @Test
    public void testXML(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop1.xml");
        //有接口 使用动态代理
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoImpl");
        userDao.save();
        System.out.println(userDao.getClass());
        System.out.println("---------------------");
        //没有接口 使用cglib代理
        OrderDaoImpl orderDaoImpl = (OrderDaoImpl)applicationContext.getBean("orderDaoImpl");
        orderDaoImpl.save();
        System.out.println(orderDaoImpl.getClass());
    }
}
