package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R226_3 {
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:36 MB,击败了27.74% 的Java用户
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left=right;
        root.right=left;
        invert(left);
        invert(right);
    }
}
