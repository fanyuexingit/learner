/**
 * @description:
 * @author: Andy
 * @time: 2021/02/03 9:44
 */
package com.fan.learn.aop.dynamicProxy;

/**
 * Created by fanyuexin on 2021/02/03
 */
public class PersonDaoImpl implements PersonDao{
    @Override
    public int save() {
        System.out.println("save data");
        return 0;
    }
}
