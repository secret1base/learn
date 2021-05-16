package leetcode.review;

import leetcode.A103_ZigzagSequenceTraversalOfBinaryTree;
import leetcode.tool.TreeNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R103_1 {
    //给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层序遍历如下：
//
//
//[
//  [3],
//  [20,9],
//  [15,7]
//]
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        left.left=new TreeNode(4);
        right.right=new TreeNode(5);
        List<List<Integer>> list = new R103_1().zigzagLevelOrder(treeNode);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    /**
     * 		执行耗时:1 ms,击败了98.67% 的Java用户
     * 		内存消耗:38.6 MB,击败了50.42% 的Java用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean left=false;
        while (!queue.isEmpty()){
            Deque<Integer> deque=new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(left){
                    deque.addFirst(node.val);
                }else{
                    deque.addLast(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(new ArrayList<>(deque));
            left=!left;
        }
        return list;
    }
}
