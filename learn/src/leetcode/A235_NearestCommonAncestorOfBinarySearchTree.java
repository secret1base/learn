package leetcode;

import leetcode.tool.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @author: wyj
 * @date: 2021/07/28
 */
public class A235_NearestCommonAncestorOfBinarySearchTree {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *  例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
     *  235.png
     *  示例 1:
     *
     *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *  示例 2:
     *
     *  输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *  说明:
     *  所有节点的值都是唯一的。
     *  p、q 为不同节点且均存在于给定的二叉搜索树中。
     *  和236一样的题目
     *  		执行耗时:6 ms,击败了89.62% 的Java用户
     * 			内存消耗:39.3 MB,击败了43.07% 的Java用户
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
