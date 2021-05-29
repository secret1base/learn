package leetcode;

import leetcode.tool.TreeNode;

/**
 * 112. 路径总和
 * @author: wyj
 * @date: 2021/05/28
 */
public class A112_TotalPath {
    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
     * 这条路径上所有节点值相加等于目标和targetSum 。
     *  叶子节点 是指没有子节点的节点。
     *  示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     *  示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：false
     *  示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：false
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.6 MB,击败了17.62% 的Java用户
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dorecord(root,0,targetSum);
    }

    private boolean dorecord(TreeNode root, int sum, int targetSum) {
        if(root==null){
            return false;
        }
        if(sum+root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        return dorecord(root.left,sum+root.val,targetSum)||dorecord(root.right,sum+root.val,targetSum);
    }
}
