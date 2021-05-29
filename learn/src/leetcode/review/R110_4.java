package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R110_4 {
    /**
     * 		执行耗时:1 ms,击败了99.99% 的Java用户
     * 		内存消耗:38.4 MB,击败了80.15% 的Java用户
     */
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        balanced(root);
        return flag;
    }

    private int balanced(TreeNode root) {
        if(root==null||!flag){
            return 0;
        }
        int left = balanced(root.left);
        int right = balanced(root.right);
        if(Math.abs(right-left)>1){
            flag=false;
        }
        return Math.max(left,right)+1;
    }
}
