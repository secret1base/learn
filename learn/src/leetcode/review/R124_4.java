package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R124_4 {
    //路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。
//
// 路径和 是路径中各节点值的总和。
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=Math.max(getMax(root.left),0);
        int right=Math.max(getMax(root.right),0);
        max=Math.max(left+right+root.val,max);
        return Math.max(left,right)+root.val;
    }
}
