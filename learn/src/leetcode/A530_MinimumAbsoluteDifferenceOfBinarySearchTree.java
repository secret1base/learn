package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * @author: wyj
 * @date: 2021/07/09
 */
public class A530_MinimumAbsoluteDifferenceOfBinarySearchTree {
    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *  示例：
     *  输入：
     *    1
     *     \
     *      3
     *     /
     *    2
     * 输出：
     * 1
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     *  提示：
     *  树中至少有 2 个节点。
     *  		执行耗时:5 ms,击败了6.76% 的Java用户
     * 			内存消耗:39 MB,击败了10.28% 的Java用户
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        record(root,list);
        Collections.sort(list);
        int min=Integer.MAX_VALUE;
        for (int i=0;i<list.size();i++){
            if(i+1<list.size()){
                Integer left = list.get(i);
                Integer right = list.get(i + 1);
                min=Math.min(right-left,min);
            }
        }
        return min;
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        record(root.left,list);
        record(root.right,list);
    }
}
