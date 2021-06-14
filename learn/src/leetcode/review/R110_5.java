package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R110_5 {
    /**
     * 			执行耗时:1 ms,击败了99.99% 的Java用户
     * 			内存消耗:38.5 MB,击败了65.22% 的Java用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        check(root);
        return flag;
    }
    boolean flag=true;
    private int check(TreeNode root) {
        if(root==null||flag==false){
            return 0;
        }
        int left=check(root.left);
        int right=check(root.right);
        if(Math.abs(right-left)>1){
            flag=false;
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
