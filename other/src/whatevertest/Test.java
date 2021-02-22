/**
 * @description:
 * @author: Andy
 * @time: 2021/01/26 14:08
 */
package whatevertest;

/**
 * Created by fanyuexin on 2021/01/26
 */
class Test extends A{
    void test(){

        super.i = 10;
        this.i = 8;
        System.out.println("super.i = " + super.i);
        System.out.println("this.i = " + this.i);
    }
    public static void main(String[] args) {
        new Test().test();
    }

    private void test0(){
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


class A{
    int i;
}


