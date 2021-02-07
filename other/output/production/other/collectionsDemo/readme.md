# collections 集合

## 1. 概念
早在 Java 2 中之前，Java 就提供了特设类。比如：Dictionary, Vector, Stack, 和 Properties 这些类用来存储和操作对象组。  
虽然这些类都非常有用，但是它们缺少一个核心的，统一的主题。由于这个原因，使用 Vector 类的方式和使用 Properties 类的方式有着很大不同。  

集合框架被设计成要满足以下几个目标：
+ 该框架必须是高性能的。基本集合（动态数组，链表，树，哈希表）的实现也必须是高效的。
+ 该框架允许不同类型的集合，以类似的方式工作，具有高度的互操作性。
+ 对一个集合的扩展和适应必须是简单的。  

为此，整个集合框架就围绕一组标准接口而设计。你可以直接使用这些接口的标准实现，诸如： LinkedList, HashSet, 和 TreeSet 等,除此之外你也可以通过这些接口实现自己的集合。

集合与数组：
+ 数组能存放基本数据类型和对象，而集合类存放的都是对象，集合类不能存放基本数据类型。数组和集合存放的对象皆为对象的引用地址。
+ 数组容易固定无法动态改变，集合类容量动态改变。
+ 数组无法判断其中实际存有多少元素，length只告诉了数组的容量，而集合的size()可以确切知道元素的个数
+ 集合有多种实现方式和不同适用场合，不像数组仅采用顺序表方式
+ 集合以类的形式存在，具有封装、继承、多态等类的特性，通过简单的方法和属性即可实现各种复杂操作，大大提高了软件的开发效率

## 2. 集合架构
* Iterator
* Collection
* List
    * AbstractList
        * ArrayList
        * LinkedList
        * Vector
            * Stack
* Set
    * AbstractSet
        * HashSet
            * LinkedHashSet
        * TreeSet
        * EnumSet
* Queue
    * Deque
        * ArrayDeque
        * LinkedList
***
* Map
    * AbstractMap
        * HashMap
            * LinkedHashMap
        * TreeMap
        * EnumMap
        * WeakHashMap
        * IdentityHashMap
    * SortedMap
    * ConcurrentMap
        * ConcurrentHashMap
    * Hashtable

![替代文字](../../resource/collection0.png)

## 3. 集合详解
* List(底层是数组; 有序 可重复)
    * ArrayList         （底层数组； 随机访问快 插入删除慢）
    * LinkedList        （底层双向链表； 随机访问慢 插入删除快）
    * Vector            （底层数组； 线程安全）
        * Stack         （底层栈； 线程安全）
* Set（底层是Map: 无序 唯一）
    * HashSet           （底层HashMap； hashCode()元素定位快； 快速查找； 值可为null）
        * LinkedHashSet （底层双向链表； hashCode()元素定位快 链表插入删除快；）
    * TreeSet           （底层红黑树； 元素必须实现Comparable接口 利于比较排列； ）
    * EnumSet           （EnumSet 的实现和 EnumMap 没有一点关系； EnumSet 是用位向量实现的，对于只有两种状态且需要进行集合运算的数据使用位向量进行表示、位运算进行处理，精简且高效。）
* Queue（队列）
    * ArrayDeque（基于数组的双端队列； ArrayDeque 是用循环数组实现的，通过对头尾变量的维护，实现了高效的队列操作。）
***
* Map（底层键值对）
    * HashMap           （底层散列； 键可null 值可null; ）
        * LinkedHashMap （底层散列 双向链表；键可null 值可null; ）
    * TreeMap           （底层红黑树； 元素必须实现Comparable接口 利于比较排列；键不可null 值可null; ）
    * EnumMap           （键为枚举类型可以使用专门的实现类 EnumMap 它使用效率更高的数组实现； ）
    * WeakHashMap
    * IdentityHashMap
    * ConcurrentMap
        * ConcurrentHashMap
    * Hashtable




