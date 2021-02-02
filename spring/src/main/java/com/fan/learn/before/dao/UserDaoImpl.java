/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 13:41
 */
package com.fan.learn.before.dao;

import com.fan.learn.before.domain.User;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(User user) {
        System.out.println("add a user object");
        return 0;
    }
}
