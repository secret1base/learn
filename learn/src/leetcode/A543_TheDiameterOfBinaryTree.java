package leetcode;

import leetcode.tool.TreeNode;

/**
 * 543.二叉树的直径
 * @author: wyj
 * @date: 2021/05/21
 */
public class A543_TheDiameterOfBinaryTree {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     *  示例 :
     * 给定二叉树
     *            1
     *          / \
     *         2   3
     *        / \
     *       4   5
     *  返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *  注意：两结点之间的路径长度是以它们之间边的数目表示。
     * @param root
     * @return
     */
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        int i = new A543_TheDiameterOfBinaryTree().diameterOfBinaryTree(a1);
        System.out.println(i);

    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.2 MB,击败了86.88% 的Java用户
     */
    int max=1;
    public int diameterOfBinaryTree(TreeNode root) {
        climb(root);
        return max-1;
    }

    private int climb(TreeNode root) {
        if(root==null){
            return 0;
        }
        //左的最大节点数
        int left=climb(root.left);
        //右的最大节点数
        int right=climb(root.right);
        max=Math.max(left+right+1,max);
        //返回单边最大值
        return Math.max(left,right)+1;
    }
}
