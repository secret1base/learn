package leetcode;

import leetcode.tool.TreeNode;

/**
 * 226.翻转二叉树
 * @author: wyj
 * @date: 2021/05/25
 */
public class A226_FlipBinaryTree {
    /**
     * 翻转一棵二叉树。
     *  示例：
     *  输入：
     *       4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *  输出：
     *       4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *  备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     * @param root
     * @return
     */
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.8 MB,击败了74.80% 的Java用户
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left=right;
        root.right=left;
        reverse(left);
        reverse(right);
    }
}
