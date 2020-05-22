package datastructure.test;

import datastructure.Queue;

/**
 * 测试队:进队、出队、判空、获取长度、遍历
 * @author: wyj
 * @date: 2020/05/22
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> list = new Queue<>();
        list.enqueue("一一");
        list.enqueue("二二");
        list.enqueue("三三");
        list.enqueue("四四");
        list.enqueue("五五");
        list.enqueue("六六");
        list.enqueue("七七");
        list.enqueue("八八");
        list.enqueue("九九");
        list.enqueue("十十");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------------");
        while (!list.isEmpty()){
            System.out.println(list.dequeue());
        }
        System.out.println(list.size());
    }
}
