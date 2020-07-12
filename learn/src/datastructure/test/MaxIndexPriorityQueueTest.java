package datastructure.test;

import datastructure.Heap;
import datastructure.MaxIndexPriorityQueue;

/**
 * 最大索引优先队列测试
 * @author: wyj
 * @date: 2020/06/22
 */
public class MaxIndexPriorityQueueTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(1);
        heap.add("D");
        heap.add("B");
        heap.add("A");
        heap.add("E");
        heap.add("C");
        //堆结构为EDABC
        MaxIndexPriorityQueue<String> queue = new MaxIndexPriorityQueue<String>(1);
        queue.enqueue("D");
        queue.enqueue("B");
        queue.enqueue("A");
        queue.enqueue("E");
        queue.enqueue("C");
        Comparable[] arr = queue.getArr();
        int[] indexArr = queue.getIndexArr();
        for (int i=1;i<=5;i++){
            System.out.println(arr[indexArr[i]].toString());
        }
        System.out.println("---------");
        //输出为EDABC，indexArr确定为堆结构索引
        queue.update(0,"O");
        arr = queue.getArr();
        indexArr = queue.getIndexArr();
        for (int i=1;i<=5;i++){
            System.out.println(arr[indexArr[i]].toString());
        }
        for (int i=0;i<queue.size();i++){
            System.out.println(arr[i].equals(queue.get(i)));
        }
        queue.update(4,"P");
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
