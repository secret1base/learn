package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 404. 左叶子之和
 * @author: wyj
 * @date: 2021/07/22
 */
public class A404_SumOfLeftLeaves {
    /**
     * 			执行耗时:1 ms,击败了17.53% 的Java用户
     * 			内存消耗:36.3 MB,击败了23.73% 的Java用户
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        Deque<TreeNode> path=new LinkedList<>();
        if(root==null){
            return sum;
        }
        path.offerLast(root);
        while (!path.isEmpty()){
            TreeNode node = path.pollFirst();
            if(node.left!=null){
                TreeNode left = node.left;
                if(left.left==null&&left.right==null){
                    sum+=node.left.val;
                }
                path.offerLast(left);
            }
            if(node.right!=null){
                path.offerLast(node.right);
            }
        }
        return sum;
    }
}
