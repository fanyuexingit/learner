# generics 泛型

## 1. 概念
Java泛型（generics）是JDK 5中引入的一个新特性，泛型提供了编译时类型安全监测机制，该机制允许程序员在编译时监测非法的类型。  
使用泛型机制编写的程序代码要比那些杂乱地使用Object变量，然后再进行强制类型转换的代码具有更好的安全性和可读性。  
泛型对于集合类尤其有用，例如，ArrayList就是一个无处不在的集合类。  
> 本质是语法糖，编译时期将会确定类型  
> 将本在运行时期的可能发生的错误，在编译时期解决

## 2. 作用
先看多态例子  
List 泛型接口

    public interface List <E> {
        void add(E x);
        Iterator<E> iterator();
    }
    
List<Integer> 相当于

    public interface IntegerList {
        void add(Integer x);
        Iterator<Integer> iterator();
    }
    
再看类型转换例子  
没有泛型的时候，需要类型转换，转换失误就会报错
    
    List myIntList = new LinkedList(); // 1
    myIntList.add(new Integer(0)); // 2
    Integer x = (Integer) myIntList.iterator().next(); // 3 
    
有泛型的时候，类型有约束，不需要数据转换

    List<Integer> myIntList = new LinkedList<Integer>(); // 1'
    myIntList.add(new Integer(0)); // 2'
    Integer x = myIntList.iterator().next(); // 3'
    
## 3. 使用
泛型有三种常用的使用方式：泛型类，泛型接口和泛型方法  
泛型通配符<T, E, K, V> <?> <? extends className> <? super className>
### 3.1 泛型类

    class className<T>{}

### 3.2 泛型接口

    interface interfaceName<T>{}

### 3.3 泛型方法

    <T> T methodName(){}  

注意  

    //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
    //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
    //所以在这个方法中才可以继续使用 T 这个泛型。
    public T getKey(){
        return key;
    }
    
    
    /** 
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个 
     *    如：public <T,K> K showKeyName(Generic<T> container){
     *        ...
     *        }
     */
    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }




***
reference: https://docs.oracle.com/javase/tutorial/extra/generics/index.html