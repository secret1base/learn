package leetcode;

import leetcode.tool.TreeNode;

/**
 * 617. 合并二叉树
 * @author: wyj
 * @date: 2021/07/15
 */
public class A617_MergeBinaryTrees {
    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *  你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
     *  示例 1:
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     *  注意: 合并必须从两个树的根节点开始。
     *
     *  		执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.4 MB,击败了90.40% 的Java用户
     *
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {
        TreeNode root=null;
        if(root1!=null&&root2!=null){
            root=new TreeNode(root1.val+root2.val);
            root.left=merge(root1.left,root2.left);
            root.right=merge(root1.right,root2.right);
        }else if(root1!=null||root2!=null){
            root=root1!=null?root1:root2;
        }
        return root;
    }
}
