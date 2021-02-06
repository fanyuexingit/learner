package com.fan.learn.ioc0.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("default implementation");
    }
}
