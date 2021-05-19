package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 94.二叉树的中序遍历
 * @author: wyj
 * @date: 2021/05/17
 */
public class A94_MiddleOrderTraversalOfBinaryTree {
    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *  示例 1：
     *  94(1).jpg
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     *  示例 2：
     * 输入：root = []
     * 输出：[]
     *  示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *  示例 4：
     *  94(2).jpg
     * 输入：root = [1,2]
     * 输出：[2,1]
     *  示例 5：
     *  94(3).jpg
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  提示：
     *  树中节点数目在范围 [0, 100] 内
     *  -100 <= Node.val <= 100
     *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    /**
     * 总结规律就是，先左子节点再父节点再右子节点
     * 递归解法
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:36.5 MB,击败了91.23% 的Java用户
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        doWrite(root,list);
//        return list;
//    }
//
//    private void doWrite(TreeNode root, List<Integer> list) {
//        if (root==null){
//            return;
//        }
//        doWrite(root.left, list);
//        list.add(root.val);
//        doWrite(root.right, list);
//    }

    /**
     * 迭代解法 TODO
     * @param root
     * @return
     */

}
