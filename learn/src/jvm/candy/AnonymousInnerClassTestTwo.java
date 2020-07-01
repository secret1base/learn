package jvm.candy;

/**
 * 匿名内部类的语法糖
 * @author: wyj
 * @date: 2020/07/01
 */
public class AnonymousInnerClassTestTwo {
    public static void main(String[] args) {
        int x=0;
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("run"+x);
            }
        };
    }
}
