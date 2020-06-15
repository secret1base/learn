package jvm.jvmtest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 验证软引用是否进入老年代
 * @author: wyj
 * @date: 2020/06/13
 */
public class SoftReferenceAndOldGeneration {
    private static final int _4MB = 28 * 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("软引用对象创建之前");
//        Thread.sleep(30000);
        List<WeakReference<byte[]>> list = new ArrayList<>();
        // 引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
//        for (int i = 0; i < 5; i++) {
            // 关联了引用队列， 当软引用所关联的 byte[]被回收时，软引用自己会加入到 queue 中去
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
//        }
        System.out.println("软引用对象创建完成");
        Thread.sleep(30000);
        System.gc();
        System.out.println("垃圾回收完成");
        Thread.sleep(30000);
        //结论：软引用对象也会进入老年代，虚引用对象由于生命周期的原因不会进入老年代
    }
}
