package jvm.jvmtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串去重验证 2
 * @author: wyj
 * @date: 2020/06/17
 */
public class StringDuplicateRemove2 {
    private static Class clazz=null;
    private static Constructor constructor=null;
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        {
//            /**
//             * 错误的验证示例，具体原因不明
//             */
//            /**
//             * 注：尝试过如下代码debuge查看a和b的value字段值，
//             * 发现在一开始value值的引用地址就是相同的，无法直接通过如下方法测试
//             */
//            String a=new String("ab");
//            String b=new String("ab");
//        }
        {
            /**
             * 正确验证示例
             * vm参数:-XX:+UseG1GC -XX:+UseStringDeduplication -XX:StringDeduplicationAgeThreshold=1 默认值1
             */
            getClazz();
            List<Object> list=new ArrayList<>();
            //1、通过如下方法来规避String对象中的value发生上面的错误示例中的问题：char[]引用地址值一样的问题
            for (int j=0;j<2;j++){
                for (int i=0;i<1;i++){
                    list.add(newString("ab"+i));
                }
            }
            //2、通过反射来获取String对象的value字段的值
            getCharArrReferece(list.get(0),list.get(1));
            //3、需要调用两次GC，原因是-XX:StringDeduplicationAgeThreshold最小值为1，
            // 最少也得存活一次后，下一次才能去重
            System.gc();
            System.gc();
            getCharArrReferece(list.get(0),list.get(1));
            Thread.sleep(10000L);
            //输出结果:-XX:+UseStringDeduplication 开启为 false true 关闭为false false
        }
    }

    /**
     * 获取类的声明
     * @return
     */
    private static void getClazz() throws ClassNotFoundException, NoSuchMethodException {
        clazz=Class.forName("java.lang.String");
        constructor=clazz.getConstructor(String.class);
    }

    private static Object newString(String old) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance(old);
    }

    private static void getCharArrReferece(Object a,Object b) {
        //获取到Person(String name,int age) 构造函数
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            boolean flag = field.isAccessible();
            try {
                //设置该属性总是可访问
                field.setAccessible(true);
                if("value".equals(field.getName())){
                    System.out.println(field.get(a)==field.get(b));
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
            //还原可访问权限
            field.setAccessible(flag);
        });
    }
}
