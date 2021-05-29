package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R226_1 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left=right;
        root.right=left;
        reverse(root.left);
        reverse(root.right);
    }
}
