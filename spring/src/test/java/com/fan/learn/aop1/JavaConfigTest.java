/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 10:26
 */
package com.fan.learn.aop1;

import com.fan.learn.AopJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AopJavaConfig.class)
public class JavaConfigTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDaoImpl orderDaoImpl;

    @Test
    public void testJavaConfig(){
        userDao.save();
        System.out.println(userDao.getClass());
        System.out.println("---------------------");
        orderDaoImpl.save();
        System.out.println(orderDaoImpl.getClass());
    }
}
