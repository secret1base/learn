package datastructure.test;

import datastructure.MinPriorityQueue;

/**
 * 最小优先队列测试
 * @author: wyj
 * @date: 2020/06/18
 */
public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> heap = new MinPriorityQueue<>(1);
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
