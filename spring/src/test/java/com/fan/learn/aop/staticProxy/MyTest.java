/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:25
 */
package com.fan.learn.aop.staticProxy;

import org.junit.Test;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class MyTest {

    @Test
    public void test0(){
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
