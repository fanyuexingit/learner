/**
 * @description:
 * @author: Andy
 * @time: 2021/01/26 13:22
 */
package serializableDemo;

import java.io.*;

/**
 * Created by fanyuexin on 2021/01/26
 */
public class Test {

    public static void main(String[] args){
        writePerson();
        readPerson();
    }

    public static void writePerson(){
        try {
            Person person = new Person();
            person.setId(0);
            person.setName("fanyuexin");
            person.setAge(26);
            person.setSex(1);
            person.setIdno("410511199410271211");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\workspace_learn\\learner\\other\\src\\serializableDemo\\test.txt")));
            objectOutputStream.writeObject(person);
            System.out.println("serialize object person successfully");
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPerson(){
        Person person = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("D:\\workspace_learn\\learner\\other\\src\\serializableDemo\\test.txt")));
            person = (Person)objectInputStream.readObject();
            System.out.println("deserialize object person successfully");
            objectInputStream.close();
            System.out.println(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
