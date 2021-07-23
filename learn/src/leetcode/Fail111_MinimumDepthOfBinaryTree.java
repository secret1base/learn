package leetcode;

import leetcode.tool.TreeNode;

/**
 * 111. 二叉树的最小深度
 * @author: wyj
 * @date: 2021/07/13
 */
public class Fail111_MinimumDepthOfBinaryTree {
    /**
     * 给定一个二叉树，找出其最小深度。
     *  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *  说明：叶子节点是指没有子节点的节点。
     *  示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *  示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     */

    //错的莫名奇妙
//    public int minDepth(TreeNode root) {
//        //起码得有一个叶子节点,才能算做最小深度
//        return getMin(root,0);
//    }
//
//    private int getMin(TreeNode root, int i) {
//        if(root==null){
//            return 0;
//        }
//        int left = getMin(root.left, i + 1);
//        int right = getMin(root.right, i + 1);
//        if(i==0){
//            if(left==0){
//                return right+1;
//            }else{
//                return left+1;
//            }
//        }
//        return Math.min(left,right)+1;
//    }
//
//    public static void main(String[] args) {
//        TreeNode a1 = new TreeNode(1);
//        TreeNode a2 = new TreeNode(2);
//        TreeNode a3 = new TreeNode(3);
//        TreeNode a4 = new TreeNode(4);
//        TreeNode a5 = new TreeNode(5);
//        a1.left=a2;
//        a2.left=a3;
//        a3.left=a4;
//        a4.left=a5;
//        int min = new Fail111_MinimumDepthOfBinaryTree().getMin(a1, 0);
//        System.out.println(min);
//    }


}
