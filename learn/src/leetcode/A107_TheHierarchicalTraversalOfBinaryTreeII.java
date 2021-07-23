package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * @author: wyj
 * @date: 2021/07/15
 */
public class A107_TheHierarchicalTraversalOfBinaryTreeII {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *  例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  返回其自底向上的层序遍历为：
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     * 		执行耗时:1 ms,击败了99.2% 的Java用户
     * 		内存消耗:38.6 MB,击败了66.0% 的Java用户
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> path=new LinkedList<>();
        path.offerLast(root);
        while (!path.isEmpty()){
            int size = path.size();
            List<Integer> tmp=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = path.pollFirst();
                tmp.add(node.val);
                if(node.left!=null){
                    path.offerLast(node.left);
                }
                if(node.right!=null){
                    path.offerLast(node.right);
                }
            }
            list.add(tmp);
        }
        //倒序排列
        int mid = list.size() / 2;
        for (int i = 0; i < mid; i++) {
            List<Integer> t = list.get(i);
            list.set(i,list.get(list.size() - i - 1));
            list.set(list.size()-i-1,t);
        }
        return list;
    }
}
