/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:19
 */
package com.fan.learn.aop.now;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class ProxyFactory {

    private static Object target;
    private static Aop aop;

    public static Object getProxyInstance(Object target_, Aop aop_) {

        //目标对象和关键点代码的类都是通过外界传递进来
        target = target_;
        aop = aop_;

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        aop.begin();
                        Object returnValue = method.invoke(target, args);
                        aop.close();

                        return returnValue;
                    }
                }
        );
    }
}
