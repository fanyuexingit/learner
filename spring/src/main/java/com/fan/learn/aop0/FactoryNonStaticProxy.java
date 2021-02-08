/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 16:05
 */
package com.fan.learn.aop0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fanyuexin on 2021/02/08
 */
public class FactoryNonStaticProxy {

    public Object getProxyInstance(final Object target_, final Aop aop_) {
        return Proxy.newProxyInstance(
                target_.getClass().getClassLoader(),
                target_.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop_.begin();
                        Object returnValue = method.invoke(target_, args);
                        aop_.close();
                        return returnValue;
                    }
                }
        );
    }
}
