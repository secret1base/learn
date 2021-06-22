package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * @author: wyj
 * @date: 2021/06/22
 */
public class A230_TheK_thSmallestElementInBinarySearchTree {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *  示例 1：
     *  230(1).jpg
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     *  示例 2：
     *  230(2).jpg
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     *
     * 先进行中序遍历根据二叉搜索树的性质就得到了由小到大的数组
     * 			执行耗时:1 ms,击败了49.47% 的Java用户
     * 			内存消耗:39.5 MB,击败了5.41% 的Java用户
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        record(root,list);
        return list.get(k-1);
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        record(root.left,list);
        list.add(root.val);
        record(root.right, list);
    }
}
