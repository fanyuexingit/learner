package com.fan.learn.ioc0.dao;

public class UserDaoImplMysql implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql implementation");
    }
}
