package datastructure.test;

import datastructure.BinaryTree;
import datastructure.Queue;

/**
 * @author: wyj
 * @date: 2020/06/03
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer,String> tree=new BinaryTree<>();
        tree.put(1,"yi");
        tree.put(10,"shi");
        tree.put(8,"ba");
        tree.put(30,"sanshi");
        tree.put(2,"er");
        tree.put(5,"wu");
        tree.put(4,"si");
        tree.put(3,"san");
        tree.put(31,"sanshiyi");
        System.out.println(tree.size()==10);
        System.out.println(tree.isEmpty()==false);
        System.out.println("前序遍历如下：");
        Queue<Integer> preKeys = tree.preErgodic();
        for (Integer preKey : preKeys) {
            System.out.println("key="+preKey+";value="+tree.get(preKey));
        }
        System.out.println("中序遍历如下：");
        Queue<Integer> midKeys = tree.midErgodic();
        for (Integer preKey : midKeys) {
            System.out.println("key="+preKey+";value="+tree.get(preKey));
        }
        System.out.println("后序遍历如下：");
        Queue<Integer> afterKeys = tree.afterErgodic();
        for (Integer preKey : afterKeys) {
            System.out.println("key="+preKey+";value="+tree.get(preKey));
        }
        System.out.println(tree.getMaxKey());
        System.out.println(tree.getMinKey());
    }
}
