package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R543_2 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getPath(root);
        return max;
    }

    private int getPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getPath(root.left);
        int right=getPath(root.right);
        max=Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
