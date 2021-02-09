/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 15:00
 */
package com.fan.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fanyuexin on 2021/02/09
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(){
        userDao.save();
        int i = 1 / 0;
        userDao.save();
    }
}
