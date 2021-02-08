/**
 * @description:
 * @author: Andy
 * @time: 2021/02/07 15:55
 */
package com.fan.learn.ioc1;

import com.fan.learn.ioc0.service.Service;
import com.fan.learn.ioc1.domain.Child;
import com.fan.learn.ioc1.domain.Person;
import com.fan.learn.ioc1.domain.Student;
import com.fan.learn.ioc1.service.PersonService;
import com.fan.learn.ioc1.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/07
 */

public class XMLTest {

    //上次的例子改为xml配置
    @Test
    public void test0(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc1.xml");
        Service service = (Service) applicationContext.getBean("serviceImpl");
        service.dosome();
    }

    //通过 setter 注入各种类型
    @Test
    public void test00(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc1.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    //1、通过 setter 注入  2、通过 constructor 注入
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
        PersonService personService = (PersonServiceImpl)context.getBean("personServiceImpl");

        Person person = new Person();
        person.setId(1);
        person.setName("fanyuexin");
        person.setSex("male");
        Child child = new Child();
        child.setAge(2);
        child.setNickname("funny");
        person.setChild(child);

        personService.add(person);
    }

}
