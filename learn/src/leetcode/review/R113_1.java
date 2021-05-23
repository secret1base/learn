package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R113_1 {
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
// 示例 1：
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 示例 2：
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 示例 3：
//输入：root = [1,2], targetSum = 0
//输出：[]
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Integer> path=new Stack<>();
        path.push(root.val);
        doWrite(root,root.val,targetSum,list,path);
        return list;
    }

    private void doWrite(TreeNode root, int sum, int targetSum, List<List<Integer>> list, Stack<Integer> path) {
        if(root==null){
            return;
        }
        //必须为叶子节点
        if(root.left==null&&root.right==null&&sum==targetSum){
            list.add(new ArrayList<>(path));
        }
        if(root.left!=null){
            path.push(root.left.val);
            doWrite(root.left,sum+root.left.val,targetSum,list,path);
            path.pop();
        }
        if(root.right!=null){
            path.push(root.right.val);
            doWrite(root.right,sum+root.right.val,targetSum,list,path);
            path.pop();
        }
    }
}
