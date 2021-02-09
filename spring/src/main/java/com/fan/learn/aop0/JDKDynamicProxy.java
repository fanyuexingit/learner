/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:46
 */
package com.fan.learn.aop0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class JDKDynamicProxy{

    UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserDao getProxy(){
        return (UserDao) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(), userDaoImpl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                method.invoke(userDaoImpl, args);
                System.out.println("after");
                return proxy;
            }
        });
    }
}
