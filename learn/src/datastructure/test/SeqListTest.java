package datastructure.test;

import datastructure.SeqList;

/**
 * 顺序表
 * @author: wyj
 * @date: 2020/05/20
 */
public class SeqListTest {
    public static void main(String[] args) {
        SeqList<String> list = new SeqList<>(5);
        list.add("一一");
        list.add("二二");
        list.add("三三");
        list.add("四四");
        list.add("五五");
        list.add("六六");
        list.add("七七");
        list.add("八八");
        list.add("九九");
        list.add("十十");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("--------------");
        //1、顺序表的实现：新增、插入新增、扩容缩容、指定删除、遍历
        list.insert(0,"放在一一的前面");
        for (String s : list) {
            System.out.println(s);
        }
        String remove = list.remove(0);
        System.out.println(remove);
        System.out.println("-------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
