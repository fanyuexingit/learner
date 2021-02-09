/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 14:10
 */
package com.fan.learn.ioc1;

import com.fan.learn.IocAnnotationConfig;
import com.fan.learn.ioc1.domain.Person;
import com.fan.learn.ioc1.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= IocAnnotationConfig.class)
public class AnnotationTest {

    @Autowired
    private PersonService personService;

    //annotation 方式
    @Test
    public void test0(){
        personService.add(new Person());
    }

    //annotation 方式
    @Test
    public void test00(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocAnnotationConfig.class);
        PersonService personService = (PersonService) applicationContext.getBean("personServiceImpl");
        personService.add(new Person());
    }

}
