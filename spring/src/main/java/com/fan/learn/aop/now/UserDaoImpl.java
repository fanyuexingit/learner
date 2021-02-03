/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 13:16
 */
package com.fan.learn.aop.now;

import org.springframework.stereotype.Repository;

/**
 * Created by fanyuexin on 2021/02/03
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public int save() {
        System.out.println("save a object");
        return 0;
    }
}
