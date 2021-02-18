/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 14:54
 */
package concurrencyDemo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by fanyuexin on 2021/02/18
 */
//优点：可以获取结果 可以抛出异常
public class TestCallable implements Callable<Integer> {

    public Integer call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        return randomNumber;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable1 = new TestCallable();
        TestCallable testCallable2 = new TestCallable();
        TestCallable testCallable3 = new TestCallable();
        //创建服务，线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        //若是runnable,用execute方法
        //若是callable,用submit方法
        Future<Integer> future1 = executorService.submit(testCallable1);
        Future<Integer> future2 = executorService.submit(testCallable2);
        Future<Integer> future3 = executorService.submit(testCallable3);
        //获取结果
        Integer integer1 = future1.get();
        Integer integer2 = future2.get();
        Integer integer3 = future3.get();
        System.out.println(integer1+" "+integer2+" "+integer3);
        //关闭服务
        executorService.shutdownNow();
    }
}
