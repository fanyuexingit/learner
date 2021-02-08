/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:31
 */
package com.fan.learn.ioc1.service;

import com.fan.learn.ioc1.dao.PersonDao;
import com.fan.learn.ioc1.dao.PersonDaoImpl;
import com.fan.learn.ioc1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/02
 */
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

//    setter方法
//    public void setPersonDao(PersonDao personDao) {
//        this.personDao = personDao;
//    }

//    构造函数
//    public PersonService(PersonDao personDao) {
//        this.personDao = personDao;
//    }





    public void add(Person person) {
        personDao.add(person);
    }
}
