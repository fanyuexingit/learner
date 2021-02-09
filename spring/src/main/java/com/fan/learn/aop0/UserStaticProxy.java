/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:22
 */
package com.fan.learn.aop0;

import com.fan.learn.aop0.UserDao;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class UserStaticProxy implements UserDao {

    private UserDao userDao;

    public UserStaticProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("before");
        userDao.save();
        System.out.println("after");
    }
}
