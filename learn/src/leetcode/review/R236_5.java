package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R236_5 {
    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
// 示例 1：
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

    /**
     * 			执行耗时:7 ms,击败了99.92% 的Java用户
     * 			内存消耗:40.5 MB,击败了67.96% 的Java用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
}
