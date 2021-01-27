/**
 * @description:
 * @author: Andy
 * @time: 2021/01/26 13:23
 */
package serializableDemo;

import java.io.Serializable;

/**
 * Created by fanyuexin on 2021/01/26
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private int sex;
    private String idno;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", idno='" + idno + '\'' +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }
}
