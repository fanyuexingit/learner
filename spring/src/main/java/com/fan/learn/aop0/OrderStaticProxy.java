/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 11:06
 */
package com.fan.learn.aop0;

/**
 * Created by fanyuexin on 2021/02/09
 */
public class OrderStaticProxy extends OrderDaoImpl{

    @Override
    public void save() {
        System.out.println("before");
        super.save();
        System.out.println("after");
    }
}
