package jvm.classStruct;

/**
 * 验证iadd效果为将操作数栈中的两个元素加为一个元素
 * @author: wyj
 * @date: 2020/06/23
 */
public class AddTest {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        int c=3;
        int d=a+b+c;

    }
    /**
     *  javac AddTest.java
     *  javap -v AddTest.class
     * Classfile /D:/learnworkspace/learn/src/jvm/classStruct/AddTest.class
     *   Last modified 2020-6-23; size 304 bytes
     *   MD5 checksum f7872248c5c70edca6dde859560be700
     *   Compiled from "AddTest.java"
     * public class jvm.classStruct.AddTest
     *   minor version: 0
     *   major version: 52
     *   flags: ACC_PUBLIC, ACC_SUPER
     * Constant pool:
     *    #1 = Methodref          #3.#12         // java/lang/Object."<init>":()V
     *    #2 = Class              #13            // jvm/classStruct/AddTest
     *    #3 = Class              #14            // java/lang/Object
     *    #4 = Utf8               <init>
     *    #5 = Utf8               ()V
     *    #6 = Utf8               Code
     *    #7 = Utf8               LineNumberTable
     *    #8 = Utf8               main
     *    #9 = Utf8               ([Ljava/lang/String;)V
     *   #10 = Utf8               SourceFile
     *   #11 = Utf8               AddTest.java
     *   #12 = NameAndType        #4:#5          // "<init>":()V
     *   #13 = Utf8               jvm/classStruct/AddTest
     *   #14 = Utf8               java/lang/Object
     * {
     *   public jvm.classStruct.AddTest();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: return
     *       LineNumberTable:
     *         line 8: 0
     *
     *   public static void main(java.lang.String[]);
     *     descriptor: ([Ljava/lang/String;)V
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=5, args_size=1
     *          0: iconst_1
     *          1: istore_1
     *          2: iconst_2
     *          3: istore_2
     *          4: iconst_3
     *          5: istore_3
     *          6: iload_1
     *          7: iload_2
     *          8: iadd   这里
     *          9: iload_3
     *         10: iadd   这里
     *         11: istore        4
     *         13: return
     *       LineNumberTable:
     *         line 10: 0
     *         line 11: 2
     *         line 12: 4
     *         line 13: 6
     *         line 15: 13
     * }
     * SourceFile: "AddTest.java"
     */
}
