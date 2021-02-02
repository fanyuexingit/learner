/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 10:28
 */
package com.fan.learn.now.domain;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class Child {
    private String nickname;
    private int age;

    public Child() {

    }

    public Child(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
