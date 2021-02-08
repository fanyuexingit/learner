/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 14:10
 */
package com.fan.learn.ioc1;

import com.fan.learn.PersonAnnotationConfig;
import com.fan.learn.PersonJavaConfig;
import com.fan.learn.ioc1.domain.Person;
import com.fan.learn.ioc1.service.PersonService;
import com.fan.learn.ioc1.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PersonAnnotationConfig.class)
public class AnnotationTest {

    @Autowired
    private PersonService personService;

    //annotation 方式
    @Test
    public void test0(){
        personService.add(new Person());
    }

}
