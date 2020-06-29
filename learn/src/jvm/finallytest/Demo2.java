package jvm.finallytest;

/**
 * @author: wyj
 * @date: 2020/06/29
 */
public class Demo2 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);//20
    }
    public static int test() {
        try {
            int i=1/0;
            return 10;
        } finally {
            return 20;
        }
    }
}
