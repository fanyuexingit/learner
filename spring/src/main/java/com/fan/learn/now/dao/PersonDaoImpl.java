/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:33
 */
package com.fan.learn.now.dao;

import com.fan.learn.now.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/02
 */
//@Component
public class PersonDaoImpl implements PersonDao {
    @Override
    public int add(Person person) {
        System.out.println("add a person");
        return 0;
    }
}
