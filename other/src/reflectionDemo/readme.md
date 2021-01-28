# reflection 反射

## 1. 概念
* 使用的前提条件：必须先得到代表的字节码的Class，Class类用于表示.class文件（字节码）
* JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
* 在运行时判断任意一个对象所属的类；在运行时构造任意一个类的对象；在运行时判断任意一个类所具有的成员变量和方法；在运行时调用任意一个对象的方法；生成动态代理。
* 要想解剖一个类,必须先要获取到该类的字节码文件对象。而解剖使用的就是Class类中的方法.所以先要获取到每一个字节码文件对应的Class类型的对象.

## 2. 使用
反射的基本步骤：
1. 获得Class对象解剖一
2. 实例化对象
3. 访问对象

获取class对象3种方式
1. 通过每个对象都具备的方法getClass来获取
    * 弊端：必须要创建该类对象，才可以调用getClass方法
2. 每一个数据类型(基本数据类型和引用数据类型)都有一个静态的属性class
    * 弊端：必须要先明确该类
3. 使用的Class类中的方法，静态的forName方法
    * 优点：不用明确类或对象
```text
          // 1. 根据给定的类名来获得  用于类加载
　　　　　　String classname = "cn.itcast.reflect.Person";// 来自配置文件
　　　　　　Class clazz = Class.forName(classname);// 此对象代表Person.class
　　　　　　// 2. 如果拿到了对象，不知道是什么类型   用于获得对象的类型
　　　　　　Object obj = new Person();
　　　　　　Class clazz1 = obj.getClass();// 获得对象具体的类型
　　　　　　// 3. 如果是明确地获得某个类的Class对象  主要用于传参
　　　　　　Class clazz2 = Person.class;
```



***
reference: https://docs.oracle.com/javase/tutorial/reflect/index.html