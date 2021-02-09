/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 10:24
 */
package com.fan.learn;

import com.fan.learn.aop1.Aop;
import com.fan.learn.aop1.OrderDaoImpl;
import com.fan.learn.aop1.UserDao;
import com.fan.learn.aop1.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by fanyuexin on 2021/02/09
 */
@Configuration
@EnableAspectJAutoProxy
public class AopJavaConfig {

    @Bean
    public Aop getAop(){
        return new Aop();
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

    @Bean
    public OrderDaoImpl getOrderDaoImpl(){
        return new OrderDaoImpl();
    }
}
