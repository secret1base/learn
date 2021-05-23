package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113.路径总和 II
 * @author: wyj
 * @date: 2021/05/20
 */
public class A113_PathSummationII {
    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *  叶子节点 是指没有子节点的节点。
     *  示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *  示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     *  示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *  提示：
     *  树中节点总数在范围 [0, 5000] 内
     *  -1000 <= Node.val <= 1000
     *  -1000 <= targetSum <= 1000
     */
    public static void main(String[] args) {
//        TreeNode a5=new TreeNode(5);
//        TreeNode a4=new TreeNode(4);
//        TreeNode a8=new TreeNode(8);
//        TreeNode a11=new TreeNode(11);
//        TreeNode a13=new TreeNode(13);
//        TreeNode a41=new TreeNode(4);
//        TreeNode a7=new TreeNode(7);
//        TreeNode a2=new TreeNode(2);
//        TreeNode a51=new TreeNode(5);
//        TreeNode a1=new TreeNode(1);
//        a5.left=a4;
//        a5.right=a8;
//        a4.left=a11;
//        a11.left=a7;
//        a11.right=a2;
//        a8.left=a13;
//        a8.right=a41;
//        a41.left=a51;
//        a41.right=a1;
//        List<List<Integer>> list = new A113_PathSummationII().pathSum(a5, 22);
//        TreeNode node = new TreeNode(-2);
//        node.right=new TreeNode(-3);
//        List<List<Integer>> list = new A113_PathSummationII().pathSum(node, -5);
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(-2);
        TreeNode c=new TreeNode(1);
        TreeNode d=new TreeNode(-1);
        a.left=b;
        b.left=c;
        c.left=d;
        List<List<Integer>> list = new A113_PathSummationII().pathSum(a, -1);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    /**
     * 注意这道题目有两个陷阱:坑了我好久
     * 1、当路径和为目标值时，当前节点还必须为叶子节点才能够将值保存
     * 2、当路径和为目标值时，和其它题目的区别是，在其他题目时不管找没找到都已经进行return，不再继续向下执行了，
     * 但是在这道题不是的，这道题只要不是叶子节点就必须继续向下执行
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //比较简单，遍历出所有可能即可
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<Integer> path=new Stack<>();
        path.push(root.val);
        doSearch(root,root.val,targetSum,path,list);
        return list;
    }

    private void doSearch(TreeNode root, int sum, int targetSum, Stack<Integer> path, List<List<Integer>> list) {
//        System.out.println(path);
        ////注意：这里是这道题目最坑爹的地方，必须为叶子节点,必须没有下一个节点
        if(root.left==null&&root.right==null&&sum==targetSum){
            list.add(new ArrayList<>(path));
        }
        if(root.left!=null){
            path.push(root.left.val);
            doSearch(root.left,sum+root.left.val,targetSum,path,list);
            path.pop();
        }
        if(root.right!=null){
            path.push(root.right.val);
            doSearch(root.right,sum+root.right.val,targetSum,path,list);
            path.pop();
        }
    }
}
