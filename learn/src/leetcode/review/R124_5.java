package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R124_5 {
    //路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。
// 路径和 是路径中各节点值的总和。
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
// 示例 1：
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    //			执行耗时:1 ms,击败了100.00% 的Java用户
    //			内存消耗:40 MB,击败了93.37% 的Java用户
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        check(root);
        return max;
    }

    private int check(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=Math.max(check(root.left),0);
        int rigth=Math.max(check(root.right),0);
        max=Math.max(left+rigth+root.val,max);
        return Math.max(left,rigth)+root.val;
    }
}
