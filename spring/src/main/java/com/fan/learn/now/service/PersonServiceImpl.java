/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:31
 */
package com.fan.learn.now.service;

import com.fan.learn.now.dao.PersonDaoImpl;
import com.fan.learn.now.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/02
 */
//@Component
public class PersonServiceImpl implements PersonService {

    private PersonDaoImpl personDaoImpl;

//    setter方法
//    public void setPersonDaoImpl(PersonDaoImpl personDaoImpl) {
//        this.personDaoImpl = personDaoImpl;
//    }

//    构造函数
//    @Autowired
    public PersonServiceImpl(PersonDaoImpl personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    public void add(Person person) {
        personDaoImpl.add(person);
    }
}
