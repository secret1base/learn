package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R102_1 {
    //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//[
//  [3],
//  [9,20],
//  [15,7]
//]

    /**
     * 			执行耗时:2 ms,击败了10.33% 的Java用户
     * 			内存消耗:38.5 MB,击败了85.92% 的Java用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Deque<Integer> deque=new LinkedList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                deque.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(new ArrayList<>(deque));
        }
        return list;
    }
}
