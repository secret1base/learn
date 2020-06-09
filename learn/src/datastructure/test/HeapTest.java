package datastructure.test;

import datastructure.Heap;

/**
 * 堆测试
 * @author: wyj
 * @date: 2020/05/21
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(10);
        heap.add(1);
        heap.add(10);
        heap.add(8);
        heap.add(30);
        heap.add(2);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(31);
//        Comparable[] arr = heap.getArr();
//        for (Comparable s : arr) {
//            System.out.println(s);
//        }
        while(!heap.isEmpty()){
            System.out.println(heap.delMax());
        }
    }
}
