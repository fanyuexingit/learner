# 注解 annotation (from jdk1.5)
### 内置注解
* @Deprecated 过时 用于过时的类、方法、成员变量等
* @Override 覆盖父类方法 
* @SuppressWarning 阻止警告
* @FunctionalInterface 指定接口必须为函数式接口
* @SafeVarargs "堆污染警告"
* 
### 元注解
* @Retention 保留期，能设定注解的存活时间
* @Documented 将注解中的元素包含到Javadoc中
* @Target 限定注解能运用的地方
* @Inherited 标明注解是能被继承的，例如B继承了A，A添加了注解，那么B也会继承同样的注解

### 自定义注解
```text
public @interface Xxx{
  int a();
  char b();    
}
//使用
@Xxx(a=1,b="b")
```