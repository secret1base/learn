package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R112_1 {
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38.2 MB,击败了80.83% 的Java用户
    boolean flag=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return flag;
        }
        check(root.val,root,targetSum);
        return flag;
    }

    private void check(int sum, TreeNode root, int targetSum) {
        if(sum==targetSum&&root.left==null&&root.right==null){
            flag=true;
            return;
        }
        if(root.left!=null){
            check(sum+root.left.val,root.left,targetSum);
        }
        if(root.right!=null){
            check(sum+root.right.val,root.right,targetSum);
        }
    }
}
