/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:22
 */
package com.fan.learn.aop.staticProxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class UserDaoProxy implements UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int save() {
        System.out.println("before");
        userDao.save();
        System.out.println("after");
        return 0;
    }
}
