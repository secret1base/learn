package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R113_4 {
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，
// 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
//
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Integer> path=new Stack<>();
        path.push(root.val);
        doRecord(root,root.val,targetSum,path,list);
        return list;
    }

    private void doRecord(TreeNode root, int curr, int targetSum, Stack<Integer> path, List<List<Integer>> list) {
        if(curr==targetSum&&root.left==null&&root.right==null){
            list.add(new ArrayList<>(path));
        }
        if(root.left!=null){
            path.push(root.left.val);
            doRecord(root.left,curr+root.left.val,targetSum,path,list);
            path.pop();
        }
        if(root.right!=null){
            path.push(root.right.val);
            doRecord(root.right,curr+root.right.val,targetSum,path,list);
            path.pop();
        }
    }
}
