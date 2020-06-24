package jvm.classStruct;

/**
 * <clinit>
 *  0: bipush        10
 *  2: putstatic     #2                  // Field i:I
 *  5: bipush        20
 *  7: putstatic     #2                  // Field i:I
 *  10: bipush        30
 *  12: putstatic     #2                  // Field i:I
 *  15: return
 * @author: wyj
 * @date: 2020/06/23
 */
public class StaticValueClass {
    static int i = 10;
    static {
        i = 20;
    }
    static {
        i = 30;
    }

    public static void main(String[] args) {
        System.out.println(StaticValueClass.i);//30
    }
}
/**
 * Classfile /D:/learnworkspace/learn/src/jvm/classStruct/StaticValueClass.class
 *   Last modified 2020-6-23; size 325 bytes
 *   MD5 checksum 9fa502c357c485b99e4a4e3cc46783c1
 *   Compiled from "StaticValueClass.java"
 * public class jvm.classStruct.StaticValueClass
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#14         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #3.#15         // jvm/classStruct/StaticValueClass.i:I
 *    #3 = Class              #16            // jvm/classStruct/StaticValueClass
 *    #4 = Class              #17            // java/lang/Object
 *    #5 = Utf8               i
 *    #6 = Utf8               I
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               <clinit>
 *   #12 = Utf8               SourceFile
 *   #13 = Utf8               StaticValueClass.java
 *   #14 = NameAndType        #7:#8          // "<init>":()V
 *   #15 = NameAndType        #5:#6          // i:I
 *   #16 = Utf8               jvm/classStruct/StaticValueClass
 *   #17 = Utf8               java/lang/Object
 * {
 *   static int i;
 *     descriptor: I
 *     flags: ACC_STATIC
 *
 *   public jvm.classStruct.StaticValueClass();
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
 *   static {};
 *     descriptor: ()V
 *     flags: ACC_STATIC
 *     Code:
 *       stack=1, locals=0, args_size=0
 *          0: bipush        10
 *          2: putstatic     #2                  // Field i:I
 *          5: bipush        20
 *          7: putstatic     #2                  // Field i:I
 *         10: bipush        30
 *         12: putstatic     #2                  // Field i:I
 *         15: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 10: 5
 *         line 13: 10
 *         line 14: 15
 * }
 * SourceFile: "StaticValueClass.java"
 */
