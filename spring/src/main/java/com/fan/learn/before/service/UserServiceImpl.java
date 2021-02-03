/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 13:39
 */
package com.fan.learn.before.service;

import com.fan.learn.before.dao.DaoFactory;
import com.fan.learn.before.domain.User;
import com.fan.learn.before.dao.UserDao;
import com.fan.learn.before.dao.UserDaoImpl;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class UserServiceImpl implements UserService {
    @Override
    public int add(User user) {
        //第一种方式 直接new一个新对象
//        UserDaoImpl userDao = new UserDaoImpl();


        //写 DaoFactory 用字符串来维护依赖关系
        UserDao userDao = DaoFactory.getInstance().createDao("com.fan.learn.before.dao.UserDaoImpl", UserDaoImpl.class);


        userDao.add(user);
        return 0;
    }
}
