/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:19
 */
package com.fan.learn.aop.staticProxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int save() {
        System.out.println("save data");
        return 0;
    }
}
