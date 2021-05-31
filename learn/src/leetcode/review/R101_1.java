package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R101_1 {
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return false;
        }
        return check(root.left,root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }


}
