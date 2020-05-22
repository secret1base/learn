package datastructure.test;

import datastructure.Stack;

/**
 * 栈测试：压栈、弹栈、判空、获取长度、遍历
 * @author: wyj
 * @date: 2020/05/22
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> list = new Stack<>();
        list.push("一一");
        list.push("二二");
        list.push("三三");
        list.push("四四");
        list.push("五五");
        list.push("六六");
        list.push("七七");
        list.push("八八");
        list.push("九九");
        list.push("十十");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");
        while (!list.isEmpty()){
            System.out.println(list.pop());
        }
        System.out.println(list.size());
    }
}
