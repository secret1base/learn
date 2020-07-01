package jvm.candy;

/**
 * @author: wyj
 * @date: 2020/06/30
 */
public class VariableElement {
    public static void method(String ...parameter){
        String[] a=parameter;
        System.out.println(a);
    }

    public static void main(String[] args) {
        method("a","b");
    }
}
