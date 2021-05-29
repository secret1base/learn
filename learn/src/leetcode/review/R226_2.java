package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R226_2 {
    // 输入：
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
// 输出：
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left=right;
        root.right=left;
        reverse(root.right);
        reverse(root.left);
    }
}
