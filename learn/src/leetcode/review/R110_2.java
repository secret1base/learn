package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R110_2 {
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        getDepath(root);
        return flag;
    }

    private int getDepath(TreeNode root) {
        if(root==null||!flag){
            return 0;
        }
        int left=getDepath(root.left);
        int right=getDepath(root.right);
        if(Math.abs(right-left)>1){
            flag=false;
            return 0;
        }
        return Math.max(left,right)+1;
    }
}
