package com.fan.learn.ioc0.service;

import com.fan.learn.ioc0.dao.Dao;
import com.fan.learn.ioc0.dao.DaoFactory;
import com.fan.learn.ioc0.dao.DaoImpl;
import com.fan.learn.ioc0.dao.DaoImplMysql;

public class ServiceImpl implements Service {

    //最原始的方式 new一个具体实现类
//    Dao dao = new DaoImplMysql();

    //反射工厂方式
//    Dao dao = DaoFactory.getInstance().createDao("com.fan.learn.ioc0.dao.DaoImpl", DaoImpl.class);

    //利用setter注入
    private Dao dao;
    public void setDao(Dao dao){
        this.dao = dao;
    }

    //利用constructor注入
//    private Dao dao;
//    public ServiceImpl(Dao dao){
//        this.dao = dao;
//    }



    @Override
    public void dosome() {
        dao.dosome();
    }
}
