/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 16:11
 */
package com.fan.learn;

import com.fan.learn.now.dao.PersonDaoImpl;
import com.fan.learn.now.service.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fanyuexin on 2021/02/02
 */
@Configuration
public class ConfigJava {

    @Bean
    public PersonDaoImpl getPersonDaoImpl(){
        return new PersonDaoImpl();
    }

    @Bean
    public PersonServiceImpl getPersonServiceImpl(PersonDaoImpl personDaoImpl){
        return new PersonServiceImpl(personDaoImpl);
    }
}
