package jvm.finallytest;

/**
 * @author: wyj
 * @date: 2020/06/29
 */
public class Demo3 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);//10
    }
    public static int test() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
        }
    }
}
