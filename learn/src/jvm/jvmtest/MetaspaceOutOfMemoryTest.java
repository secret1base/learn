package jvm.jvmtest;


import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 元空间内存溢出测试
 * -XX:MaxMetaspaceSize=9m
 * @author: wyj
 * @date: 2020/06/09
 */
public class MetaspaceOutOfMemoryTest extends ClassLoader{
    public static void main(String[] args) {
        int j=0;
        try{
            MetaspaceOutOfMemoryTest test = new MetaspaceOutOfMemoryTest();
            for (int i=0;i<10000;i++,j++){
                //生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //根据后面的条件创建一个类：1、版本号 2、public 3、类名 4、包名 5、父类 6、接口
                cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"class"+i,null,"java/lang/Object",null);
                byte[] code = cw.toByteArray();
                //执行类加载
                test.defineClass("class"+i,code,0,code.length);//class对象
            }
        }finally {
            System.out.println(j);
        }
    }
}
