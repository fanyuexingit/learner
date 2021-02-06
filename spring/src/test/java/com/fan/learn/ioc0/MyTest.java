package com.fan.learn.ioc0;

import com.fan.learn.ioc0.dao.UserDaoImpl;
import com.fan.learn.ioc0.dao.UserDaoImplMysql;
import com.fan.learn.ioc0.dao.UserDaoImplOracle;
import com.fan.learn.ioc0.service.UserService;
import com.fan.learn.ioc0.service.UserServiceImpl;
import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        //利用setter注入
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoImplMysql());

        //利用constructor注入
        UserServiceImpl userService = new UserServiceImpl(new UserDaoImplOracle());
        userService.getUser();
    }
}
