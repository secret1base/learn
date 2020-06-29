package jvm.classStruct;

/**
 * @author: wyj
 * @date: 2020/06/29
 */
public class SyncTest {
    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("ok");
        }
    }
}
//    Classfile /D:/learnworkspace/learn/src/jvm/classStruct/SyncTest.class
//    Last modified 2020-6-29; size 577 bytes
//    MD5 checksum 9d54614850a7e545d412be8d2367358f
//    Compiled from "SyncTest.java"
//    public class jvm.classStruct.SyncTest
//    minor version: 0
//    major version: 52
//    flags: ACC_PUBLIC, ACC_SUPER
//    Constant pool:
//            #1 = Methodref          #2.#19         // java/lang/Object."<init>":()V
//            #2 = Class              #20            // java/lang/Object
//            #3 = Fieldref           #21.#22        // java/lang/System.out:Ljava/io/PrintStream;
//            #4 = String             #23            // ok
//            #5 = Methodref          #24.#25        // java/io/PrintStream.println:(Ljava/lang/String;)V
//            #6 = Class              #26            // jvm/classStruct/SyncTest
//            #7 = Utf8               <init>
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Utf8               LineNumberTable
//  #11 = Utf8               main
//  #12 = Utf8               ([Ljava/lang/String;)V
//  #13 = Utf8               StackMapTable
//  #14 = Class              #27            // "[Ljava/lang/String;"
//            #15 = Class              #20            // java/lang/Object
//            #16 = Class              #28            // java/lang/Throwable
//            #17 = Utf8               SourceFile
//  #18 = Utf8               SyncTest.java
//  #19 = NameAndType        #7:#8          // "<init>":()V
//            #20 = Utf8               java/lang/Object
//  #21 = Class              #29            // java/lang/System
//            #22 = NameAndType        #30:#31        // out:Ljava/io/PrintStream;
//            #23 = Utf8               ok
//  #24 = Class              #32            // java/io/PrintStream
//            #25 = NameAndType        #33:#34        // println:(Ljava/lang/String;)V
//            #26 = Utf8               jvm/classStruct/SyncTest
//  #27 = Utf8               [Ljava/lang/String;
//  #28 = Utf8               java/lang/Throwable
//  #29 = Utf8               java/lang/System
//  #30 = Utf8               out
//  #31 = Utf8               Ljava/io/PrintStream;
//  #32 = Utf8               java/io/PrintStream
//  #33 = Utf8               println
//  #34 = Utf8               (Ljava/lang/String;)V
//    {
//  public jvm.classStruct.SyncTest();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//            LineNumberTable:
//        line 7: 0
//
//        public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=2, locals=4, args_size=1
//        0: new           #2                  // class java/lang/Object
//        3: dup
//        4: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        7: astore_1
//        8: aload_1
//        9: dup
//        10: astore_2
//        11: monitorenter
//        12: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        15: ldc           #4                  // String ok
//        17: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        20: aload_2
//        21: monitorexit
//        22: goto          30
//        25: astore_3
//        26: aload_2
//        27: monitorexit
//        28: aload_3
//        29: athrow
//        30: return
//            Exception table:
//    from    to  target type
//        12    22    25   any
//        25    28    25   any
//        LineNumberTable:
//        line 9: 0
//        line 10: 8
//        line 11: 12
//        line 12: 20
//        line 13: 30
//        StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//        offset_delta = 25
//        locals = [ class "[Ljava/lang/String;", class java/lang/Object, class java/lang/Object ]
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//        offset_delta = 4
//    }
//    SourceFile: "SyncTest.java"

