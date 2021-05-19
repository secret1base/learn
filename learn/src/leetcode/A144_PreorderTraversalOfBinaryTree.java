package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 144.二叉树的前序遍历
 * @author: wyj
 * @date: 2021/05/19
 */
public class A144_PreorderTraversalOfBinaryTree {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *  示例 1：
     * 1
     *   2
     * 3
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     *  示例 2：
     * 输入：root = []
     * 输出：[]
     *  示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *  示例 4：
     *   1
     * 2
     * 输入：root = [1,2]
     * 输出：[1,2]
     *  示例 5：
     * 1
     *   2
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  提示：
     *  树中节点数目在范围 [0, 100] 内
     *  -100 <= Node.val <= 100
     */
    /**
     * 前序遍历是下面这样的形式
     *     1
     *  2     3
     *   4   5  6
     * 输出 124356
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.7 MB,击败了60.86% 的Java用户
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        doWrite(root,list);
        return list;
    }

    private void doWrite(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if(root.left!=null){
            doWrite(root.left,list);
        }
        if(root.right!=null){
            doWrite(root.right, list);
        }
    }

}
