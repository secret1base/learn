package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1038. 从二叉搜索树到更大和树
 * @author: wyj
 * @date: 2021/07/28
 */
public class A1038_FromBinarySearchTreeToLargerSumTree {
    /**
     * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
     *  提醒一下，二叉搜索树满足下列约束条件：
     *  节点的左子树仅包含键 小于 节点键的节点。
     *  节点的右子树仅包含键 大于 节点键的节点。
     *  左右子树也必须是二叉搜索树。
     *  注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
     *  示例 1：
     *  1038(1).png
     * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
     * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
     *  示例 2：
     * 输入：root = [0,null,1]
     * 输出：[1,null,1]
     *  示例 3：
     * 输入：root = [1,0,2]
     * 输出：[3,3,2]
     *  示例 4：
     * 输入：root = [3,2,4,1]
     * 输出：[7,9,4,10]
     *  提示：
     *  树中的节点数介于 1 和 100 之间。
     *  每个节点的值介于 0 和 100 之间。
     *  树中的所有值 互不相同 。
     *  给定的树为二叉搜索树。
     * @param root
     * @returns
     * 获取所有数字，升序排列，求和即可
     *           执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:36 MB,击败了29.53% 的Java用户
     */
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        record(root,list);
        return replace(root,list);
    }

    private TreeNode replace(TreeNode root, List<Integer> list) {
        if(root==null){
            return root;
        }
        int sum=0;
        for (Integer num : list) {
            if(root.val<=num){
                sum+=num;
            }
        }
        root.val=sum;
        replace(root.left,list);
        replace(root.right,list);
        return root;
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        record(root.left,list);
        list.add(root.val);
        record(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode a4=new TreeNode(4);
        TreeNode a1=new TreeNode(1);
        TreeNode a6=new TreeNode(6);
        TreeNode a0=new TreeNode(0);
        TreeNode a2=new TreeNode(2);
        TreeNode a5=new TreeNode(5);
        TreeNode a7=new TreeNode(7);
        TreeNode a3=new TreeNode(3);
        TreeNode a8=new TreeNode(8);
        a4.left=a1;
        a4.right=a6;
        a1.left=a0;
        a1.right=a2;
        a6.left=a5;
        a6.right=a7;
        a2.right=a3;
        a7.right=a8;
        System.out.println(new A1038_FromBinarySearchTreeToLargerSumTree().bstToGst(a4));
    }
}
