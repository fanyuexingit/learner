/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 14:09
 */
package com.fan.learn.before.dao;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class DaoFactory {

    private static final DaoFactory factory = new DaoFactory();
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return factory;
    }

    public <T> T createDao(String className, Class<T> clazz){
        try{
            T t = (T) Class.forName(className).newInstance();
            return t;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
