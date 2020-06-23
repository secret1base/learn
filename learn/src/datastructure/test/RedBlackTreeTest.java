package datastructure.test;

import datastructure.Queue;
import datastructure.RedBlackTree;

/**
 * 红黑树验证
 * @author: wyj
 * @date: 2020/06/23
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(6,"A");
        tree.put(2,"B");
        tree.put(4,"Z");
        tree.put(5,"D");
        tree.put(1,"O");
        tree.put(3,"P");
        Queue<Integer> queue = tree.midErgodic();
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        String a = tree.get(1);
        System.out.println(a);
        String b = tree.get(2);
        System.out.println(b);
        String c = tree.get(3);
        System.out.println(c);
        String d = tree.get(4);
        System.out.println(d);
        String e = tree.get(5);
        System.out.println(e);
        String f = tree.get(6);
        System.out.println(f);
        System.out.println(tree.validateRed());
        System.out.println(tree.getBlackCount());
    }
}
