package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R110_3 {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        //给定一个二叉树，判断它是否是高度平衡的二叉树。
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
        balanced(root);
        return flag;
    }

    private int balanced(TreeNode root) {
        if(root==null||!flag){
            return 0;
        }
        int left=balanced(root.left);
        int right=balanced(root.right);
        if(Math.abs(right-left)>1){
            flag=false;
        }
        return Math.max(left,right)+1;
    }
}
