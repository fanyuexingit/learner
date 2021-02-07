package com.fan.learn.ioc0;

import com.fan.learn.ioc0.dao.DaoImplMysql;
import com.fan.learn.ioc0.dao.DaoImplOracle;
import com.fan.learn.ioc0.service.Service;
import com.fan.learn.ioc0.service.ServiceImpl;
import org.junit.Test;

public class MyTest {

    @Test
    public void test0(){
        //最原始的方式 new一个具体实现类
//        ServiceImpl service = new ServiceImpl();

        //反射工厂方式
//        ServiceImpl service = new ServiceImpl();

        //利用setter注入
//        Service service = new ServiceImpl();
//        ((ServiceImpl)service).setDao(new DaoImplMysql());

        //利用constructor注入
//        ServiceImpl service = new ServiceImpl(new DaoImplOracle());



//        service.dosome();
    }
}
