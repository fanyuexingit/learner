# concurrency 并发 多线程

## 1. 概念
* 进程：正在进行中的程序。其实进程就是一个应用程序运行时的内存分配空间。
* 线程：其实就是进程中一个程序执行控制单元，一条执行路径。进程负责的是应用程序的空间的标示。线程负责的是应用程序的执行顺序。
***
* 一个进程至少有一个线程在运行，当一个进程中出现多个线程时，就称这个应用程序是多线程应用程序，每个线程在栈区中都有自己的执行空间，自己的方法区、自己的变量。
* jvm在启动的时，首先有一个主线程，负责程序的执行，调用的是main函数。主线程执行的代码都在main方法中。
* 当产生垃圾时，收垃圾的动作，是不需要主线程来完成，因为这样，会出现主线程中的代码执行会停止，会去运行垃圾回收器代码，效率较低，所以由单独一个线程来负责垃圾回收。 
***
* 随机性的原理：因为cpu的快速切换造成，哪个线程获取到了cpu的执行权，哪个线程就执行。
***
* 返回当前线程的名称：Thread.currentThread().getName()
* 线程的名称是由：Thread—编号定义的。编号从0开始。
* 线程要运行的代码都统一存放在了run方法中。
* 线程要运行必须要通过类中指定的方法开启。start方法。（启动后，就多了一条执行路径）
* start方法：1）、启动了线程；2）、让jvm调用了run方法。
***
* 注意：线程优先级1-10，数字越大，优先级越高，但是cpu调度不一定按照优先级顺序，优先级只能增大被调度的概率
* 用户线程 守护线程（daemon）
## 2. 使用
1. 通过继承 Thread 类本身
    1. 定义类继承Thread类
    2. 目的是复写run方法，将要让线程运行的代码都存储到run方法中
    3. 通过创建Thread类的子类对象，创建线程对象
    4. 调用线程的start方法，开启线程，并执行run方法

2. 通过实现 Runnable 接口
    1. 定义类实现Runnable接口
    2. 覆盖接口中的run方法（用于封装线程要运行的代码）
    3. 通过Thread类创建线程对象
    4. 将实现了Runnable接口的子类对象作为实际参数传递给Thread类中的构造函数
        * 为什么要传递呢？因为要让线程对象明确要运行的run方法所属的对象
    5. 调用Thread对象的start方法。开启线程，并运行Runnable接口子类中的run方法

3. 通过 Callable 和 Future 创建线程
    1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值
    2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值
    3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程
    4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
    
## 3. 线程的生命周期
线程共包括以下 5 种状态:
1. 新建状态(New): 线程对象被创建后，就进入了新建状态。例如，Thread thread = new Thread()。
2. 就绪状态(Runnable): 也被称为“可执行状态”。线程对象被创建后，其它线程调用了该对象的start()方法，从而来启动该线程。例如，thread.start()。处于就绪状态的线程，随时可能被CPU调度执行。
3. 运行状态(Running): 线程获取CPU权限进行执行。需要注意的是，线程只能从就绪状态进入到运行状态。
4. 阻塞状态(Blocked): 阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
    * (01) 等待阻塞 -- 通过调用线程的wait()方法，让线程等待某工作的完成。
    * (02) 同步阻塞 -- 线程在获取synchronized同步锁失败(因为锁被其它线程所占用)，它会进入同步阻塞状态。
    * (03) 其他阻塞 -- 通过调用线程的sleep()或join()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
5. 死亡状态(Dead): 线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
![替代文字](../../resource/concurrency0.jpg)
![替代文字](../../resource/concurrency1.jpg)

## 4. 线程的操作方法
start()
yield()

interrupt()
sleep()
join()

wait()
notify()
synchronized()

stop()

## 5. 同步
1.同步代码块
```text
synchronized(同步对象)｛ 
  需要同步的代码 
｝
```

2.同步方法
```text
synchronized 方法返回值 方法名称（参数列表）｛ ｝
```

3.特殊域变量(volatile)实现线程同步
* volatile关键字为域变量的访问提供了一种免锁机制， 
* 使用volatile修饰域相当于告诉 虚拟机该域可能会被其他线程更新， 
* 因此每次使用该域就要重新计算，而不是使用寄存器中的值 
* volatile不会提供任何原子操作，它也不能用来修饰final类型的变量  

4.使用重入锁实现线程同步  
* ReentrantLock

5.使用局部变量实现线程同步  
* ThreadLocal

## 6. 死锁
1.死锁原因  
* 所谓死锁，是指多个进程在运行过程中因争夺资源而造成的一种僵局，当进程处于这种僵持状态时，若无外力作用，它们都将无法再向前推进。

2.产生死锁的原因  
* 竞争资源
* 进程间推进顺序非法

3.死锁产生的4个必要条件
* 互斥条件：进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用
* 请求和保持条件：当进程因请求资源而阻塞时，对已获得的资源保持不放
* 不剥夺条件：进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放
* 环路等待条件：在发生死锁时，必然存在一个进程--资源的环形链

4.解决死锁的基本方法  
* 预防死锁
    * 以确定的顺序获得锁
    * 超时放弃
* 避免死锁
    * 预防死锁的几种策略，会严重地损害系统性能。因此在避免死锁时，要施加较弱的限制，从而获得 较满意的系统性能。由于在避免死锁的策略中，允许进程动态地申请资源。因而，系统在进行资源分配之前预先计算资源分配的安全性。若此次分配不会导致系统进入不安全的状态，则将资源分配给进程；否则，进程等待。其中最具有代表性的避免死锁算法是银行家算法
    * 银行家算法：首先需要定义状态和安全状态的概念。系统的状态是当前给进程分配的资源情况。因此，状态包含两个向量Resource（系统中每种资源的总量）和Available（未分配给进程的每种资源的总量）及两个矩阵Claim（表示进程对资源的需求）和Allocation（表示当前分配给进程的资源）。安全状态是指至少有一个资源分配序列不会导致死锁。当进程请求一组资源时，假设同意该请求，从而改变了系统的状态，然后确定其结果是否还处于安全状态。如果是，同意这个请求；如果不是，阻塞该进程知道同意该请求后系统状态仍然是安全的
* 检测死锁
    * 首先为每个进程和每个资源指定一个唯一的号码
    * 然后建立资源分配表和进程等待表
* 解除死锁
    * 剥夺资源：从其它进程剥夺足够数量的资源给死锁进程，以解除死锁状态
    * 撤消进程：可以直接撤消死锁进程或撤消代价最小的进程，直至有足够的资源可用，死锁状态.消除为止；所谓代价是指优先级、运行代价、进程的重要性和价值等
* 死锁检测
    * Jstack命令
    * JConsole工具

## 7. Lock 接口 实现类 ReentrantLock
private final ReentrantLock lock = new ReentrantLock();
lock.lock();
lock.unlock();

## 8. 生产者 消费者
管程法：利用缓冲区
信号灯法：利用标志位


## 9. 线程池


***
reference: https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html