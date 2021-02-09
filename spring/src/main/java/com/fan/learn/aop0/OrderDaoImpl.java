/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 16:40
 */
package com.fan.learn.aop0;

import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/08
 */
@Component
public class OrderDaoImpl {
    public void save() {
        System.out.println("save order");
    }
}
