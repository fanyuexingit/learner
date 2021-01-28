# I/O input/output 输入输出流

## 1. 概念
* Java对设备中数据的操作是通过流的方式。表示任何有能力产出数据的数据源对象，或者是有能力接受数据的接收端对象。“流”屏蔽了实际的I/O设备中处理数据的细节。IO流用来处理设备之间的数据传输。设备是指硬盘、内存、键盘录入、网络等。
* 按操作数据类型的不同分为两种： 字节流与字符流
* 按流向分为：                输入流与输出流 （以程序为参照物，输入到程序，或是从程序输出）

## 2. I/O 架构
* InputStream(Closeable)
    * ByteArrayInputStream 
    * FileInputStream
    * PipedInputStream
    * FilterInputStream
        * DataInputStream
        * BufferedInputStream
        * LineNumberInputStream
        * PushbackInputStream
    * ObjectInputStream
    * SequenceInputStream
    * StringBufferInputStream
    
* OutputStream(Closeable Flushable)
    * ByteArrayOutputStream 
    * FileOutputStream
    * PipedOutputStream
    * FilterOutputStream
        * DataOutputStream
        * BufferedOutputStream
        * PrintStream
    * ObjectOutputStream

* Reader(Closeable Readable)
    * CharArrayReader
    * FileReader
    * PipedReader
    * FilterReader(A)
        * PushbackReader
    * BufferedReader
        * LineNumberReader
    * StringReader
    
* Writer(Closeable Flushable Appendable)
    * CharArrayWriter
    * FileWriter
    * PipedWriter
    * FilterWriter(A)
    * BufferedWriter
    * StringWriter

## 3. 总结
```text
FileInputStream/FileOutputStream 需要逐个字节处理原始二进制流的时候使用，效率低下。
FileReader/FileWriter 需要组个字符处理的时候使用。
StringReader/StringWriter 需要处理字符串的时候，可以将字符串保存为字符数组。
PrintStream/PrintWriter 用来包装FileOutputStream 对象，方便直接将String字符串写入文件 。
Scanner　用来包装System.in流，很方便地将输入的String字符串转换成需要的数据类型。
InputStreamReader/OutputStreamReader , 字节和字符的转换桥梁，在网络通信或者处理键盘输入的时候用。
BufferedReader/BufferedWriter， BufferedInputStream/BufferedOutputStream， 缓冲流用来包装字节流后者字符流，提升IO性能，BufferedReader还可以方便地读取一行，简化编程。
SequenceInputStream(InputStream s1, InputStream s2)序列流，合并流对象时使用.
ObjectInputStream、ObjectOutputStream，方法用于序列化对象并将它们写入一个流，另一个方法用于读取流并反序列化对象。
ByteArrayInputStream、ByteArrayOutputStream，操作数组
DataInputStream、DataOutputStream操作基本数据类型和字符串。

```

***
reference： https://docs.oracle.com/javase/tutorial/essential/io/index.html