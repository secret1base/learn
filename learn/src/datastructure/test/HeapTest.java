package datastructure.test;

import datastructure.Heap;

/**
 * 堆测试
 * @author: wyj
 * @date: 2020/05/21
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(10);
        heap.add("a");
        heap.add("b");
        heap.add("c");
        heap.add("d");
        heap.add("e");
        heap.add("f");
        heap.add("g");
        heap.add("h");
        Comparable[] arr = heap.getArr();
        for (Comparable s : arr) {
            System.out.println(s);
        }
//        while(!heap.isEmpty()){
//            System.out.println(heap.delMax());
//        }
    }
}
