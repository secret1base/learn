package jvm.jvmtest;

/**
 * 测试字符串的编译器优化在不同版本jdk中的区别,在jdk1.5时就已经会把"a"+"b"在编译器优化为"ab"
 * @author: wyj
 * @date: 2020/06/14
 */
public class TestCompileOptimizeInDifferentJDK {
    public static void main(String[] args) {
        String s="a"+"b";
    }
}
