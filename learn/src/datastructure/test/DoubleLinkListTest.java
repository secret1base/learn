package datastructure.test;

import datastructure.DoubleLinkList;

/**
 * @author: wyj
 * @date: 2020/05/21
 */
public class DoubleLinkListTest {
    public static void main(String[] args) {
        DoubleLinkList<String> list = new DoubleLinkList<String>();
        list.add("唱歌");
        list.add("跳舞");
        list.add("玩游戏");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.indexOf("跳舞"));
        System.out.println("-------------------------------------");

        list.insert(1,"预计在唱歌后面");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------");
        System.out.println(list.getFirst()+"--"+list.getLast());
        System.out.println("-------------------------------------");
        String remove = list.remove(1);
        System.out.println(remove);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.get(0));
        list.clear();
        System.out.println(list.isEmpty());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
