package jvm.finallytest;

/**
 * finally测试1
 * @author: wyj
 * @date: 2020/06/29
 */
public class Demo1 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);//20
    }
    public static int test() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }
}
