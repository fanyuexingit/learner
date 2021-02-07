/**
 * @description:
 * @author: Andy
 * @time: 2021/02/07 15:55
 */
package com.fan.learn.ioc1;

import com.fan.learn.ioc0.service.Service;
import com.fan.learn.ioc1.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fanyuexin on 2021/02/07
 */
public class MyTest {
    @Test
    public void test0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc1.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.getId()+" "+user.getName());
    }

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc1.xml");
        Service service = (Service) applicationContext.getBean("serviceImpl");
        service.dosome();
    }
}
