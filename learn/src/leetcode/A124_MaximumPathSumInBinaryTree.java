package leetcode;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 124.二叉树中的最大路径和
 * @author: wyj
 * @date: 2021/05/20
 */
public class A124_MaximumPathSumInBinaryTree {
    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
     * 一定经过根节点。
     *  路径和 是路径中各节点值的总和。
     *  给你一个二叉树的根节点 root ，返回其 最大路径和 。
     *  示例 1：
     *  124(1).jpg
     * 输入：root = [1,2,3]
     * 输出：6
     * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     *  示例 2：
     *  124(2).jpg
     * 输入：root = [-10,9,20,null,null,15,7]
     * 输出：42
     * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
     *  提示：
     *  树中节点数目范围是 [1, 3 * 104]
     *  -1000 <= Node.val <= 1000
     */

    public static void main(String[] args) {
        TreeNode a=new TreeNode(-10);
        TreeNode b=new TreeNode(9);
        TreeNode c=new TreeNode(20);
        TreeNode d=new TreeNode(15);
        TreeNode e=new TreeNode(7);
        a.left=b;
        a.right=c;
        c.left=d;
        c.right=e;
        int i = new A124_MaximumPathSumInBinaryTree().maxPathSum(a);
        System.out.println(i);
    }
    int maxSum=Integer.MIN_VALUE;

    /**
     * 解题关键:
     * 1、求最大和需要将当前连接点加入进去
     * 2、返回给上级节点当前节点所能提供的收益时，只能计算单边的
     * 3、当收益为负数时可以放弃这个节点
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        //这里和0比较的原因是，当这个节点能够提供的最大和小于0时，我就放弃这个节点
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        //计算最大值可以用当前顶点，因为必须经过
        maxSum=Math.max(left+right+root.val,maxSum);
        //返回给上级必须选取最大的那条值，只能选一条边
        return root.val+Math.max(left,right);
    }


}
