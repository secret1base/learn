package datastructure.test;

import datastructure.Heap;

/**
 * 堆测试
 * @author: wyj
 * @date: 2020/05/21
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(8);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(9);
        heap.add(2);
        heap.add(4);
        int size = heap.size();
        for(int i=0;i< size;i++){
            int max = heap.getMax();
            System.out.println(max);
        }
    }
}
