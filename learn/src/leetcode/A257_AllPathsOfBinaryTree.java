package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @author: wyj
 * @date: 2021/07/16
 */
public class A257_AllPathsOfBinaryTree {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *  说明: 叶子节点是指没有子节点的节点。
     *  示例:
     *  输入:
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * 输出: ["1->2->5", "1->3"]
     *
     * 		执行耗时:2 ms,击败了77.91% 的Java用户
     * 		内存消耗:38.4 MB,击败了84.04% 的Java用户
     *
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        Deque<String> path=new LinkedList<>();
        if(root==null){
            return list;
        }
        path.offerLast(Integer.toString(root.val));
        recordPath(root,path,list);
        return list;
    }

    private void recordPath(TreeNode root, Deque<String> path, List<String> list) {
        if(root.left==null&&root.right==null){
            StringBuilder sb=new StringBuilder();
            for (String s : path) {
                sb.append(s).append("->");
            }
            list.add(sb.toString().substring(0,sb.length()-2));
            return;
        }
        if(root.left!=null){
            path.offerLast(Integer.toString(root.left.val));
            recordPath(root.left,path,list);
            path.pollLast();
        }
        if(root.right!=null){
            path.offerLast(Integer.toString(root.right.val));
            recordPath(root.right,path,list);
            path.pollLast();
        }
    }
}
