/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 10:08
 */
package com.fan.learn;

import com.fan.learn.aop1.OrderDaoImpl;
import com.fan.learn.aop1.UserDaoImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by fanyuexin on 2021/02/09
 */
@Configuration
@ComponentScan(basePackages = "com.fan.learn.aop1")
@EnableAspectJAutoProxy
public class AopAnnotationConfig {
}
