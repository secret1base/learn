package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R124_1 {
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。
// 路径和 是路径中各节点值的总和。
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
// 示例 1：
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if(root==null){
            return 0;
        }
        //左节点的最大路径和(单边),注意舍去负值
        int left=getMax(root.left);
        left=left<0?0:left;
        //右节点的最大路径和(单边)
        int right=getMax(root.right);
        right=right<0?0:right;
        max=Math.max(max,left+right+root.val);
        //返回最大单边值(包含本节点)
        return Math.max(left,right)+root.val;
    }
}
