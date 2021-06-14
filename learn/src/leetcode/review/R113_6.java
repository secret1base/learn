package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R113_6 {
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，
// 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
    //			执行耗时:2 ms,击败了40.73% 的Java用户
//			内存消耗:38.4 MB,击败了97.08% 的Java用户
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<Integer> path=new LinkedList<>();
        path.offerLast(root.val);
        record(root.val,path,targetSum,list,root);
        return list;
    }

    private void record(int sum, Deque<Integer> path, int targetSum, List<List<Integer>> list, TreeNode root) {
        if(sum==targetSum&&root.left==null&&root.right==null){
            list.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null){
            path.offerLast(root.left.val);
            record(sum+root.left.val,path,targetSum,list,root.left);
            path.pollLast();
        }
        if(root.right!=null){
            path.offerLast(root.right.val);
            record(sum+root.right.val,path,targetSum,list,root.right);
            path.pollLast();
        }
    }
}
