package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R543_3 {
    //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
// 示例 :
//给定二叉树
//           1
//         / \
//        2   3
//       / \
//      4   5
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getMax(root.left);
        int right=getMax(root.right);
        max=Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
