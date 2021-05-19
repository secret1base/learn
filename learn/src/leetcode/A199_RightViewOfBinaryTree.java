package leetcode;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * 199.二叉树的右视图
 * @author: wyj
 * @date: 2021/05/18
 */
public class A199_RightViewOfBinaryTree {



    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *  示例:
     *  输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     *
     *    1            <---
     *  /
     * 2               <---
     *  \
     *   5             <---
     * 1,2,5
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        left.left=new TreeNode(4);
        right.right=new TreeNode(5);
        List<Integer> list = new A199_RightViewOfBinaryTree().rightSideView(treeNode);
    }

    /**
     * 通过从右往左的层序遍历后，将每一层的第一个值加入shortList
     * 		执行耗时:3 ms,击败了5.29% 的Java用户
     * 		内存消耗:38.1 MB,击败了10.39% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> shortList=new ArrayList<>();
        if(root==null){
            return shortList;
        }
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> deque=new LinkedList<> ();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                deque.addFirst(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(new ArrayList<>(deque));
        }
        for (List<Integer> integers : list) {
            shortList.add(integers.get(0));
        }
        return shortList;
    }


}
