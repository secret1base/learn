package jvm.candy;

import java.lang.reflect.Method;

/**
 * 重写桥接验证
 * @author: wyj
 * @date: 2020/07/01
 */
public class RewriteBridge {
    public static void main(String[] args) {
        Method[] declaredMethods = Son.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}
//Integer extends Number

class Father {
    public Number method(){
        return 1;
    }
}

class Son extends Father{
    @Override
    public Integer method() {
        return 2;
    }
}