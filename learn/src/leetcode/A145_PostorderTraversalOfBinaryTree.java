package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * @author: wyj
 * @date: 2021/06/17
 */
public class A145_PostorderTraversalOfBinaryTree {
    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *  示例:
     *  输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     * 输出: [3,2,1]
     *          执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.9 MB,击败了11.79% 的Java用户
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        after(root,list);
        return list;
    }

    private void after(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        after(root.left,list);
        after(root.right,list);
        list.add(root.val);
    }
}
