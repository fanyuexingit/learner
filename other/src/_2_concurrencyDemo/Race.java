/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 14:39
 */
package _2_concurrencyDemo;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class Race implements Runnable{

    private static String winner;

    public void run() {
        for (int i = 0; i <= 100; i++) {



            boolean b = gameOver(i);
            if (b){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }

    private boolean gameOver(int steps){
        if (winner != null){
            return true;
        }
        if (steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "rabbit").start();
        new Thread(race, "turtle").start();
    }
}
