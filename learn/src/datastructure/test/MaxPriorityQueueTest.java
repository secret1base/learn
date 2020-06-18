package datastructure.test;

import datastructure.MaxPriorityQueue;

/**
 * 最大优先队列测试
 * @author: wyj
 * @date: 2020/06/18
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<Integer> heap = new MaxPriorityQueue<>(1);
        heap.enqueue(1);
        heap.enqueue(10);
        heap.enqueue(8);
        heap.enqueue(30);
        heap.enqueue(31);
        heap.enqueue(2);
        heap.enqueue(5);
        heap.enqueue(4);
        heap.enqueue(3);
        heap.enqueue(31);
        System.out.println(heap.size());
        while(!heap.isEmpty()){
            System.out.println(heap.dequeue());
        }
        System.out.println(heap.size());
        heap.enqueue(31);
        System.out.println(heap.size());


    }
}
