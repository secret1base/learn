package datastructure.test;

import datastructure.Heap;

/**
 * 堆测试
 * @author: wyj
 * @date: 2020/05/21
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(1);
        heap.add(1);
        heap.add(10);
        heap.add(8);
        heap.add(30);
        heap.add(31);
        heap.add(2);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(31);
        System.out.println(heap.size());
        System.out.println(heap.isHeap());
        while(!heap.isEmpty()){
            System.out.println(heap.delMax());
        }
        System.out.println(heap.size());
        heap.add(31);
        System.out.println(heap.size());


    }

}
