package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R102_4 {
    /**
     * 二叉树：[3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  返回其层序遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        //先进先出
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Deque<Integer> tmp=new LinkedList<>();
            int size = queue.size();
            //每次在queue中只放一层的节点，节点顺序
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.offer(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(new ArrayList<>(tmp));
        }
        return list;
    }


}
