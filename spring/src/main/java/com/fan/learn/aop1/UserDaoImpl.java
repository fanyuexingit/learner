/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:19
 */
package com.fan.learn.aop1;

import org.springframework.stereotype.Component;

/**
 * Created by fanyuexin on 2021/02/03
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save data");
    }
}
