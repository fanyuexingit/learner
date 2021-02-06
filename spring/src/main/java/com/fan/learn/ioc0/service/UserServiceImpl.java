package com.fan.learn.ioc0.service;

import com.fan.learn.ioc0.dao.UserDao;
import com.fan.learn.ioc0.dao.UserDaoImplMysql;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //利用setter注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public UserServiceImpl(){}
    //利用constructor注入
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

//    最原始的方式 new一个具体实现类
//    UserDao userDao = new UserDaoImplMysql();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
