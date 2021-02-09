/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 15:45
 */
package com.fan.learn;

import com.fan.learn.ioc1.dao.PersonDaoImpl;
import com.fan.learn.ioc1.service.PersonServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fanyuexin on 2021/02/02
 */
@Configuration
@ComponentScan(basePackageClasses={PersonServiceImpl.class, PersonDaoImpl.class})
public class IocAnnotationConfig {
}
