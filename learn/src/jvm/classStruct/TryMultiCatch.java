package jvm.classStruct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: wyj
 * @date: 2020/06/28
 */
public class TryMultiCatch {
    public static void main(String[] args) {
        try {
            Method test = TryMultiCatch.class.getMethod("test");
            test.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        System.out.println("ok");
    }
}

