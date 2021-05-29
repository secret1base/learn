package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R113_5 {
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，
// 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]

    /**
     * 		执行耗时:2 ms,击败了40.96% 的Java用户
     * 		内存消耗:38.8 MB,击败了58.58% 的Java用户
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<Integer> path=new LinkedList<>();
        path.offerLast(root.val);
        record(root,path,targetSum,root.val,list);
        return list;
    }

    private void record(TreeNode root, Deque<Integer> path, int targetSum, int sum, List<List<Integer>> list) {
        if(targetSum==sum&&root.left==null&&root.right==null){
            list.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null){
            path.offerLast(root.left.val);
            record(root.left,path,targetSum,sum+root.left.val,list);
            path.pollLast();
        }
        if(root.right!=null){
            path.offerLast(root.right.val);
            record(root.right,path,targetSum,sum+root.right.val,list);
            path.pollLast();
        }
    }
}
