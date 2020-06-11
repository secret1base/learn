package jvm.jvmtest;

import datastructure.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看内存占用
 * @author: wyj
 * @date: 2020/06/09
 */
public class HeapMemoryTest2 {
    public static void main(String[] args) throws InterruptedException {
        List<Queue> objects = new ArrayList<>();
        for (int i=0;i<20000;i++){
            objects.add(new Queue());
        }
        Thread.sleep(1000000000000000L);
    }
}
