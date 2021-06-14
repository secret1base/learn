package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R104_4 {
//给定一个二叉树，找出其最大深度。
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
// 说明: 叶子节点是指没有子节点的节点。
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 返回它的最大深度 3 。
//		执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:38.4 MB,击败了52.02% 的Java用户
    public int maxDepth(TreeNode root) {
        return check(root);
    }

    private int check(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=check(root.left);
        int right=check(root.right);
        return Math.max(left,right)+1;
    }
}
