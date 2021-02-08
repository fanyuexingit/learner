/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:33
 */
package com.fan.learn.ioc1.dao;

import com.fan.learn.ioc1.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/02
 */
@Component
public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        System.out.println("add："+person);
    }
}
