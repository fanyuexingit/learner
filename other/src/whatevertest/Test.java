/**
 * @description:
 * @author: Andy
 * @time: 2021/01/26 14:08
 */
package whatevertest;

/**
 * Created by fanyuexin on 2021/01/26
 */
class Test {
    public static void main(String[] args) {
        int n = 1000;
        n = n >>> 1;
        System.out.println(n);
        n = n >>> 1;
        System.out.println(n);
        n = n >>> 2;
        System.out.println(n);
        n |= n >>> 8;
        n |= n >>> 16;
    }
}
