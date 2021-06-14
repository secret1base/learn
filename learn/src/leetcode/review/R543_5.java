package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R543_5 {
    int max=0;
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38.4 MB,击败了53.17% 的Java用户
    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return max;
    }

    private int check(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=check(root.left);
        int right=check(root.right);
        max=Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
