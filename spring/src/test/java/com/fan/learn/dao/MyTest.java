/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 14:35
 */
package com.fan.learn.dao;

import com.fan.learn.DaoAnnotationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanyuexin on 2021/02/09
 */
public class MyTest {

    //查询
    @Test
    public void test0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dao.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.query();
    }
    //事务
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dao.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    //事务
    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoAnnotationConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
