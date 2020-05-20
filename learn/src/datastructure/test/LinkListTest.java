package datastructure.test;

import datastructure.LinkList;

/**
 * @author: wyj
 * @create: 2020-05-20 15:29
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        for(int i=0;i<10;i++){
            list.add(""+i+i);
        }
//        for (String o : list) {
//            System.out.println(o);
//        }
//        String s = list.get(1);//下标从1开始
//        System.out.println(s);
//        list.insert(2,"zzzz");//00 11 zzzz 22
//        for (String s : list) {
//            System.out.println(s);
//        }
//        System.out.println(list.delete(0));//下标从0开始
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.modify(1,"kkkk");//下标从0开始
//        for (String s : list) {
//            System.out.println(s);
//        }
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());
//        list.clear();
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());
//        for (String s : list) {
//            System.out.println(s);
//        }
        System.out.println(list.getMid());//快慢指针获取中位值


    }
}
