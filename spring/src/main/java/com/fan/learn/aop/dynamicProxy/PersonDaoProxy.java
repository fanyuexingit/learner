/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:46
 */
package com.fan.learn.aop.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class PersonDaoProxy {

    PersonDaoImpl personDaoImpl = new PersonDaoImpl();

    public PersonDao getProxy(){
        return (PersonDao) Proxy.newProxyInstance(PersonDaoProxy.class.getClassLoader(), personDaoImpl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                method.invoke(personDaoImpl, args);
                System.out.println("after");
                return proxy;
            }
        });
    }
}
