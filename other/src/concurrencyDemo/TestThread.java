/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 14:12
 */
package concurrencyDemo;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("looking for it " + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        TestThread testThread2 = new TestThread();
        testThread.start();
        testThread2.start();
    }
}
