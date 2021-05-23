package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R104_1 {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getMaxDepth(root.left);
        int right=getMaxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
