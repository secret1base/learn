package leetcode.review;

import leetcode.A103_ZigzagSequenceTraversalOfBinaryTree;
import leetcode.tool.TreeNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/17
 */
public class R103_2 {
//    3
//   / \
//  9  20
//    /  \
//   15   7
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        left.left=new TreeNode(4);
        right.right=new TreeNode(5);
        List<List<Integer>> list = new R103_2().zigzagLevelOrder(treeNode);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    /**
     * 			执行耗时:2 ms,击败了17.72% 的Java用户
     * 			内存消耗:38.6 MB,击败了54.50% 的Java用户
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
        boolean left=true;
        while (!queue.isEmpty()){
            Deque<Integer> deque=new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(left){
                    deque.addLast(node.val);
                }else{
                    deque.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            left=!left;
            list.add(new ArrayList<>(deque));
        }
        return list;
    }
}
