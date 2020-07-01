package jvm.candy;

/**
 * @author: wyj
 * @date: 2020/07/01
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
    }
}
