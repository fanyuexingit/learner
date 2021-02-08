/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:18
 */
package com.fan.learn.aop0;

import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/03
 */
@Component
public class Aop {

    public void begin() {
        System.out.println("开始事务");
    }
    public void close() {
        System.out.println("关闭事务");
    }
}
