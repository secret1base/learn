package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * @author: wyj
 * @date: 2021/06/23
 */
public class A114_ExpandTheBinaryTreeIntoALinkedList {
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     *  展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *  示例 1：
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *  示例 2：
     * 输入：root = []
     * 输出：[]
     *  示例 3：
     * 输入：root = [0]
     * 输出：[0]
     * better and better
     * 			执行耗时:1 ms,击败了45.23% 的Java用户
     * 			内存消耗:37.9 MB,击败了41.54% 的Java用户
     */
    public void flatten(TreeNode root) {
        List<TreeNode> preList=new ArrayList<>();
        record(root,preList);
        TreeNode node=new TreeNode();
        for (TreeNode treeNode : preList) {
            treeNode.left=null;
            treeNode.right=null;
            node.right=treeNode;
            node=node.right;
        }
    }

    private void record(TreeNode root, List<TreeNode> preList) {
        if(root==null){
            return;
        }
        preList.add(root);
        record(root.left,preList);
        record(root.right,preList);
    }
}
