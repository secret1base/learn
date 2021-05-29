package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 101. 对称二叉树
 * @author: wyj
 * @date: 2021/05/27
 */
public class A101_SymmetricBinaryTree {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *      1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *      1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * @param root
     * @return
     */


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(0);
        boolean symmetric = new A101_SymmetricBinaryTree().isSymmetric(node);
        System.out.println(symmetric);
    }


    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.7 MB,击败了29.39% 的Java用户
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }


}
