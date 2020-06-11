package jvm.jvmtest;

/**
 * @author: wyj
 * @date: 2020/06/10
 */
public class StringCompile {
    public static void main(String[] args) {
        String x2=new String("c")+new String("d");
        String x1="cd";
        x2.intern();
        System.out.println(x2==x1);
    }
}
