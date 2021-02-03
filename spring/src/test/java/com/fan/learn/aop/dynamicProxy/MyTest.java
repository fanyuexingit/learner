/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:57
 */
package com.fan.learn.aop.dynamicProxy;

import org.junit.Test;


/**
 * Created by fanyuexin on 2021/02/03
 */
public class MyTest {

    @Test
    public void test0(){
        PersonDaoProxy personDaoProxy = new PersonDaoProxy();
        PersonDao proxy = personDaoProxy.getProxy();
        proxy.save();
    }

    @Test
    public void test1(){
        PersonDao personDao = new PersonDaoImpl();
        PersonDao proxyInstance = (PersonDao) new ProxyFactory(personDao).getProxyInstance();
        proxyInstance.save();
    }
}
