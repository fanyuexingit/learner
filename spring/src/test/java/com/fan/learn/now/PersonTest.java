/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:41
 */
package com.fan.learn.now;

import com.fan.learn.ConfigAnnotation;
import com.fan.learn.ConfigJava;
import com.fan.learn.now.domain.Child;
import com.fan.learn.now.domain.Person;
import com.fan.learn.now.service.PersonService;
import com.fan.learn.now.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ConfigJava.class)
public class PersonTest {

    //xml 方式
    @Test
    public void test0(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonServiceImpl)context.getBean("personServiceImpl");

        Person person = new Person();
        person.setId(1);
        person.setName("fan");
        person.setSex("male");
        person.setChild(new Child());

        personService.add(person);
    }


    @Autowired
    private PersonServiceImpl personService;

    //annotation 方式
    @Test
    public void test1(){
        personService.add(new Person());

    }

    //java 方式
    @Test
    public void test2(){
        personService.add(new Person());
    }
}
