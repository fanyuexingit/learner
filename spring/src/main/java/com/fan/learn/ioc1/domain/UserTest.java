/**
 * @description:
 * @author: Andy
 * @time: 2021/02/08 10:07
 */
package com.fan.learn.ioc1.domain;

/**
 * Created by fanyuexin on 2021/02/08
 */
public class UserTest {
    private int age;
    private String name;

    public UserTest() {
    }

    public UserTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
