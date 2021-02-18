/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 14:30
 */
package concurrencyDemo;

/**
 * Created by fanyuexin on 2021/02/18
 */
//出现并发问题
public class Test implements Runnable{

    private int ticketNums = 10;

    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" 拿到了第 "+ ticketNums-- +" 张票");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test, "John").start();
        new Thread(test, "sam").start();
        new Thread(test, "Peter").start();
    }
}
