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

## 4. 同步阻塞的BIO、同步非阻塞的NIO、异步非阻塞的AIO
* 我们建立网络连接的时候采用BIO模式，需要先在服务端启动一个ServerSocket，然后在客户端启动Socket来对服务端进行通信，默认情况下服务端需要对每个请求建立一堆线程等待请求，而客户端发送请求后，先咨询服务端是否有线程相应，如果没有则会一直等待或者遭到拒绝请求，如果有的话，客户端会线程会等待请求结束后才继续执行
* NIO基于Reactor，当socket有流可读或可写入socket时，操作系统会相应的通知引用程序进行处理，应用再将流读取到缓冲区或写入操作系统。  也就是说，这个时候，已经不是一个连接就要对应一个处理线程了，而是有效的请求，对应一个线程，当连接没有数据时，是没有工作线程来处理的
    * BIO与NIO一个比较重要的不同，是我们使用BIO的时候往往会引入多线程，每个连接一个单独的线程；而NIO则是使用单线程或者只使用少量的多线程，每个连接共用一个线程
    * 在NIO的处理方式中，当一个请求来的话，开启线程进行处理，可能会等待后端应用的资源(JDBC连接等)，其实这个线程就被阻塞了，当并发上来的话，还是会有BIO一样的问题
* AIO与NIO不同，当进行读写操作时，只须直接调用API的read或write方法即可。这两种方法均为异步的，对于读操作而言，当有流可读取时，操作系统会将可读的流传入read方法的缓冲区，并通知应用程序；对于写操作而言，当操作系统将write方法传递的流写入完毕时，操作系统主动通知应用程序。  即可以理解为，read/write方法都是异步的，完成后会主动调用回调函数
![替代文字](../../resource/io0.png)
***
reference： https://docs.oracle.com/javase/tutorial/essential/io/index.html