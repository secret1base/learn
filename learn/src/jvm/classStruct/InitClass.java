package jvm.classStruct;

/**
 * @author: wyj
 * @date: 2020/06/23
 */
public class InitClass {
    private String a = "s1";
    {
        b = 20;
    }
    private int b = 10;
    {
        a = "s2";
    }
    public InitClass(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        InitClass a = new InitClass("a", 1);
        System.out.println(a.a);//a
        System.out.println(a.b);//1
    }
}
/**
 *Classfile /D:/learnworkspace/learn/src/jvm/classStruct/InitClass.class
 *   Last modified 2020-6-24; size 479 bytes
 *   MD5 checksum fcdfbc8abf7461514bef7609af975811
 *   Compiled from "InitClass.java"
 * public class jvm.classStruct.InitClass
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #9.#22         // java/lang/Object."<init>":()V
 *    #2 = String             #23            // s1
 *    #3 = Fieldref           #6.#24         // jvm/classStruct/InitClass.a:Ljava/lang/String;
 *    #4 = Fieldref           #6.#25         // jvm/classStruct/InitClass.b:I
 *    #5 = String             #26            // s2
 *    #6 = Class              #27            // jvm/classStruct/InitClass
 *    #7 = String             #10            // a
 *    #8 = Methodref          #6.#28         // jvm/classStruct/InitClass."<init>":(Ljava/lang/String;I)V
 *    #9 = Class              #29            // java/lang/Object
 *   #10 = Utf8               a
 *   #11 = Utf8               Ljava/lang/String;
 *   #12 = Utf8               b
 *   #13 = Utf8               I
 *   #14 = Utf8               <init>
 *   #15 = Utf8               (Ljava/lang/String;I)V
 *   #16 = Utf8               Code
 *   #17 = Utf8               LineNumberTable
 *   #18 = Utf8               main
 *   #19 = Utf8               ([Ljava/lang/String;)V
 *   #20 = Utf8               SourceFile
 *   #21 = Utf8               InitClass.java
 *   #22 = NameAndType        #14:#30        // "<init>":()V
 *   #23 = Utf8               s1
 *   #24 = NameAndType        #10:#11        // a:Ljava/lang/String;
 *   #25 = NameAndType        #12:#13        // b:I
 *   #26 = Utf8               s2
 *   #27 = Utf8               jvm/classStruct/InitClass
 *   #28 = NameAndType        #14:#15        // "<init>":(Ljava/lang/String;I)V
 *   #29 = Utf8               java/lang/Object
 *   #30 = Utf8               ()V
 * {
 *   public jvm.classStruct.InitClass(java.lang.String, int);
 *     descriptor: (Ljava/lang/String;I)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=3
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: ldc           #2                  // String s1
 *          7: putfield      #3                  // Field a:Ljava/lang/String;
 *         10: aload_0
 *         11: bipush        20
 *         13: putfield      #4                  // Field b:I
 *         16: aload_0
 *         17: bipush        10
 *         19: putfield      #4                  // Field b:I
 *         22: aload_0
 *         23: ldc           #5                  // String s2
 *         25: putfield      #3                  // Field a:Ljava/lang/String;
 *         28: aload_0
 *         29: aload_1
 *         30: putfield      #3                  // Field a:Ljava/lang/String;
 *         33: aload_0
 *         34: iload_2
 *         35: putfield      #4                  // Field b:I
 *         38: return
 *       LineNumberTable:
 *         line 16: 0
 *         line 8: 4
 *         line 10: 10
 *         line 12: 16
 *         line 14: 22
 *         line 17: 28
 *         line 18: 33
 *         line 19: 38
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=4, locals=2, args_size=1
 *          0: new           #6                  // class jvm/classStruct/InitClass
 *          3: dup
 *          4: ldc           #7                  // String a
 *          6: iconst_1
 *          7: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
 *         10: astore_1
 *         11: return
 *       LineNumberTable:
 *         line 22: 0
 *         line 23: 11
 * }
 * SourceFile: "InitClass.java"
 */