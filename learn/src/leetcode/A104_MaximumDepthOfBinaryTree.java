package leetcode;

import leetcode.tool.TreeNode;

/**
 * 104.二叉树的最大深度
 * @author: wyj
 * @date: 2021/05/19
 */
public class A104_MaximumDepthOfBinaryTree {
    /**
     * 给定一个二叉树，找出其最大深度。
     *  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *  说明: 叶子节点是指没有子节点的节点。
     *  示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  返回它的最大深度 3 。
     */
    /**
     * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:38.3 MB,击败了68.94% 的Java用户
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return getMax(root,0);
    }

    private int getMax(TreeNode root, int level) {
        if(root==null){
            return level;
        }
        return Math.max(getMax(root.left, level + 1),getMax(root.right, level + 1));
    }
}
