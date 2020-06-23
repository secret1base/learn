package jvm.classStruct;

/**
 * @author: wyj
 * @date: 2020/06/23
 */
public class InccTest {
    public static void main(String[] args) {
        int a=10;
        int b=a++ + ++a + a--;
        System.out.println(a);//11
        System.out.println(b);//34
    }
    /**
     * javac InccTest.java
     *
     * javap -v InccTest.class
     * Classfile /D:/learnworkspace/learn/src/jvm/classStruct/InccTest.class
     *   Last modified 2020-6-23; size 303 bytes
     *   MD5 checksum 03f57fe43607c22ce11ae9b74f0cc352
     *   Compiled from "InccTest.java"
     * public class jvm.classStruct.InccTest
     *   minor version: 0
     *   major version: 52
     *   flags: ACC_PUBLIC, ACC_SUPER
     * Constant pool:
     *    #1 = Methodref          #3.#12         // java/lang/Object."<init>":()V
     *    #2 = Class              #13            // jvm/classStruct/InccTest
     *    #3 = Class              #14            // java/lang/Object
     *    #4 = Utf8               <init>
     *    #5 = Utf8               ()V
     *    #6 = Utf8               Code
     *    #7 = Utf8               LineNumberTable
     *    #8 = Utf8               main
     *    #9 = Utf8               ([Ljava/lang/String;)V
     *   #10 = Utf8               SourceFile
     *   #11 = Utf8               InccTest.java
     *   #12 = NameAndType        #4:#5          // "<init>":()V
     *   #13 = Utf8               jvm/classStruct/InccTest
     *   #14 = Utf8               java/lang/Object
     * {
     *   public jvm.classStruct.InccTest();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: return
     *       LineNumberTable:
     *         line 7: 0
     *
     *   public static void main(java.lang.String[]);
     *     descriptor: ([Ljava/lang/String;)V
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: bipush        10
     *          2: istore_1
     *          3: iload_1
     *          4: iinc          1, 1
     *          7: iinc          1, 1
     *         10: iload_1
     *         11: iadd
     *         12: iload_1
     *         13: iinc          1, -1
     *         16: iadd
     *         17: istore_2
     *         18: return
     *       LineNumberTable:
     *         line 9: 0
     *         line 10: 3
     *         line 11: 18
     * }
     * SourceFile: "InccTest.java"
     */
}
