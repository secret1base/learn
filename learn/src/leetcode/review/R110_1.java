package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R110_1 {
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
// 示例 1：
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 示例 2：
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        getLength(root);
        return flag;
    }

    private int getLength(TreeNode root) {
        if(root==null||!flag){
            return 0;
        }
        int left=getLength(root.left);
        int right=getLength(root.right);
        if(Math.abs(right-left)>1){
            flag=false;
            //结束循环
            return 0;
        }else{
            return Math.max(left,right)+1;
        }
    }
}
