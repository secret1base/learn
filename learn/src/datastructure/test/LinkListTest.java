package datastructure.test;

import datastructure.LinkList;

/**
 * 单向链表测试
 * @author: wyj
 * @date: 2020/05/20
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        for(int i=0;i<10;i++){
            list.add(""+i+i);
        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        list.insert(0,"预计在00前面");
        list.insert(9,"预计在88前面，因为已经加了一次");
        System.out.println("------------------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("------------------------");
        //单向链表：新增、插入、修改、删除、获取对应值、判空、清空、获取中位值、遍历、单向链表的反转
        System.out.println(list.get(1));//00
        System.out.println(list.getMid());
        list.modify(5,"把44变了");
        System.out.println("----------------------");
        for (String s : list) {
            System.out.println(s);
        }
        list.revirse();
        System.out.println("----------------------");
        for (String s : list) {
            System.out.println(s);
        }

        while (!list.isEmpty()){
            System.out.println(list.remove(0));
        }
        for(int i=0;i<10;i++){
            list.add(""+i+i);
        }
        list.clear();
        System.out.println(list.isEmpty()?"确实为空":"有问题");
    }
}
