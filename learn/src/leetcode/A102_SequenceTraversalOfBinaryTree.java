package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 102.二叉树的层序遍历
 * @author: wyj
 * @date: 2021/05/14
 */
public class A102_SequenceTraversalOfBinaryTree {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *  示例：
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
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        List<List<Integer>> list = new A102_SequenceTraversalOfBinaryTree().levelOrder(treeNode);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    /**
     * 			执行耗时:1 ms,击败了94.75% 的Java用户
     * 			内存消耗:38.9 MB,击败了11.28% 的Java用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        doLevel(root,0,map);
        int size = map.keySet().size();
        List<List<Integer>> list=new ArrayList<>();
        for (int i=0;i<size;i++){
            list.add(map.get(i));
        }
        return list;
    }

    private void doLevel(TreeNode root, int i, Map<Integer, List<Integer>> map) {
        if(root==null){
            return;
        }
        List<Integer> list = map.get(i);
        if (list == null) {
            list=new ArrayList<>();
            map.put(i,list);
        }
        list.add(root.val);
        doLevel(root.left,i+1,map);
        doLevel(root.right,i+1,map);
    }
}
