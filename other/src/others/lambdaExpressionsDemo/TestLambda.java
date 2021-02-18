/**
 * @description:
 * @author: Andy
 * @time: 2021/02/18 15:19
 */
package others.lambdaExpressionsDemo;

/**
 * Created by fanyuexin on 2021/02/18
 */
public class TestLambda {
    //2.静态内部类
    static class Like2 implements ILike{
        public void like() { System.out.println("i like you222"); }
    }

    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.like();

        ILike like2 = new Like2();
        like2.like();


        //3.局部内部类
        class Like3 implements ILike{
            public void like() { System.out.println("i like you333"); }
        }
        ILike like3 = new Like3();
        like3.like();

        //4.匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void like() {
                System.out.println("i like you444");
            }
        };
        like4.like();

        //5.lambda
        ILike like5 = () -> {
            System.out.println("i like you555");
        };

        like5.like();
    }
}
//函数式接口
interface ILike{
    void like();
}
//1.实现类
class Like implements ILike{
    public void like() { System.out.println("i like you"); }
}
