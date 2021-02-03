/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:23
 */
package com.fan.learn.aop.now;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MyTest {
    @Test
    public void test0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl proxy = (UserDaoImpl) applicationContext.getBean("proxy");
        proxy.save();

    }
}
