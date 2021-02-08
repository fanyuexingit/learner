/**
 * @description:
 * @author: Andy
 * @time: 2021/02/02 9:38
 */
package com.fan.learn.ioc1.domain;

/**
 * Created by fanyuexin on 2021/02/02
 */
public class Person {
    private int id;
    private String name;
    private String sex;
    private Child child;

    public Person() {
    }

    public Person(int id, String name, String sex, Child child) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.child = child;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", child=" + child +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
