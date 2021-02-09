/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 14:44
 */
package com.fan.learn.ioc1;

import com.fan.learn.IocJavaConfig;
import com.fan.learn.ioc1.domain.Person;
import com.fan.learn.ioc1.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fanyuexin on 2021/02/08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= IocJavaConfig.class)
public class JavaConfigTest {

    @Autowired()
    private PersonService personService;

    //java 方式
    @Test
    public void test3(){
        personService.add(new Person());
    }
}
