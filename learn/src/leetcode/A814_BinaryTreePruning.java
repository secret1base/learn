package leetcode;

import leetcode.tool.TreeNode;

/**
 * 814. 二叉树剪枝
 * @author: wyj
 * @date: 2021/07/22
 */
public class A814_BinaryTreePruning {
    /**
     * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
     *  返回移除了所有不包含 1 的子树的原二叉树。
     *  ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
     * 示例1:
     * 814(1).png
     * 输入: [1,null,0,0,1]
     * 输出: [1,null,0,null,1]
     * 解释:
     * 只有红色节点满足条件“所有不包含 1 的子树”。
     * 右图为返回的答案。
     * 示例2:
     * 814(2).png
     * 输入: [1,0,1,0,0,0,1]
     * 输出: [1,null,1,null,1]
     * 示例3:
     * 814(3).png
     * 输入: [1,1,0,1,1,0,1,0]
     * 输出: [1,1,0,1,1,null,1]
     *  说明:
     *  给定的二叉树最多有 200 个节点。
     *  每个节点的值只会为 0 或 1 。
     *
     *  这题解的很轻松
     *  		执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.1 MB,击败了26.21% 的Java用户
     */
    public TreeNode pruneTree(TreeNode root) {
        //移除所有子节点不含1的0节点
        //移除所有值为0的叶子节点
        return remove(root);
    }

    private TreeNode remove(TreeNode root) {
        if(root==null){
            return null;
        }
        //先去对子节点进行移除
        if(root.left!=null){
            root.left=remove(root.left);
        }
        if(root.right!=null){
            root.right=remove(root.right);
        }
        //然后判断移除后的是否为叶子节点
        if(root.val==0&&root.left==null&&root.right==null){
            //叶子节点且值为0移除
            return null;
        }
        return root;
    }
}
