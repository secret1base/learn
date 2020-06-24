package jvm.classStruct;

/**
 * 不同类型的方法调用使用的指令
 * @author: wyj
 * @date: 2020/06/24
 */
public class MethodOrder {
    //invokespecial  编译器已经确定会调用的方法
    private void test1(){}
    //invokespecial 编译器已经确定会调用的方法
    private final void test2(){}
    //invokevirtual 在编译器并不确定会调用的方法，可能是父类方法也可能是子类方法
    public void test3(){}
    //invokestatic 编译器已经确定会调用的方法
    public static void test4(){}

    public static void main(String[] args) {
        MethodOrder methodOrder = new MethodOrder();
        methodOrder.test1();
        methodOrder.test1();
    }
}
