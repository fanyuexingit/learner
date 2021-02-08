/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 16:11
 */
package com.fan.learn;

import com.fan.learn.ioc1.dao.PersonDao;
import com.fan.learn.ioc1.dao.PersonDaoImpl;
import com.fan.learn.ioc1.service.PersonService;
import com.fan.learn.ioc1.service.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fanyuexin on 2021/02/02
 */
@Configuration
public class PersonJavaConfig {

    @Bean
    public PersonService getPersonService(){
        return new PersonServiceImpl();
    }
}
