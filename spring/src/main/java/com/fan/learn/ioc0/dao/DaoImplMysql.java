package com.fan.learn.ioc0.dao;

public class DaoImplMysql implements Dao {
    @Override
    public void dosome() {
        System.out.println("Mysql implementation");
    }
}
