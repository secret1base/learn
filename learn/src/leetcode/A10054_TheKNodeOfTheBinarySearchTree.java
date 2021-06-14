package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 54.二叉搜索树的第k大节点
 * @author: wyj
 * @date: 2021/06/11
 */
public class A10054_TheKNodeOfTheBinarySearchTree {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *  示例 1:
     *  输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     *  示例 2:
     *  输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     */
    /**
     * 思路:遍历后排序后取出倒数第k个值
     * 			执行耗时:5 ms,击败了5.45% 的Java用户
     * 			内存消耗:39.7 MB,击败了5.01% 的Java用户
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        record(root,list);
        Collections.sort(list);
        return list.get(list.size()-k);
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        record(root.left,list);
        record(root.right,list);
    }
}
