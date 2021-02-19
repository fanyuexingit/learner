/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 14:23
 */
package _2_concurrencyDemo;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class TestRunnable implements Runnable{
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("looking for it " + i);
        }
    }

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
    }
}
