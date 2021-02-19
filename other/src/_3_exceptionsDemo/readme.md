# Exceptions 异常

## 1. 概念
异常处理机制能让程序在异常发生时，按照代码的预先设定的异常处理逻辑，针对性地处理异常，让程序尽最大可能恢复正常并继续执行，且保持代码的清晰。  
Java中的异常可以是函数中的语句执行时引发的，也可以是程序员通过throw 语句手动抛出的，只要在Java程序中产生了异常，就会用一个对应类型的异常对象来封装异常，JRE就会试图寻找异常处理程序来处理异常。  
Throwable类是Java异常类型的顶层父类，一个对象只有是 Throwable 类的（直接或者间接）实例，他才是一个异常对象，才能被异常处理机制识别。JDK中内建了一些常用的异常类，我们也可以自定义异常。

## 2. 异常架构 常用类
* Throwable(可抛基类)
    * Error（错误）
        * VirtualMachineError
        * AWTError
        * IOError
        * LinkageError
        * ThreadDeath
        * ......
    * Exception（异常）
        * IOException（检查异常）
        * EOFException(检查异常)
        * SQLException（检查异常）
        * ClassNotFoundException
        * CloneNotSupportedException
        * IllegalAccessException
        * InstantiationException
        * InterruptedException
        * NoSuchFieldException
        * NoSuchMethodException
        * ......
        * RuntimeException（非检查异常）
            * NullPointerException
            * ClassCastException
            * IndexOutOfBoundsException
            * ArithmeticException
            * ArrayIndexOutOfBoundsException
            * ArrayStoreException
            * IllegalArgumentException
            * IllegalMonitorStateException
            * IllegalStateException
            * IllegalThreadStateException 
            * NegativeArraySizeException
            * NumberFormatException
            * SecurityException
            * StringIndexOutOfBoundsException
            * ......

## 3. 处理异常
throw
> 方法体中抛出异常

throws
> 方法声明上抛出异常

try catch finally  
> 捕获异常

try catch  
> 多个 catch ,子类在前，父类在后  

try finally  
> 如果 try 代码块有 return 语句，先执行 finally 代码块  
> 记住：finally很有用，主要用户关闭资源。无论是否发生异常，资源都必须进行关闭  
> System.exit(0); //退出jvm，只有这种情况finally不执行。



***
reference: https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
