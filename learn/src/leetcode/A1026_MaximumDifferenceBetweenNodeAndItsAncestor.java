package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1026. 节点与其祖先之间的最大差值
 * @author: wyj
 * @date: 2021/07/28
 */
public class A1026_MaximumDifferenceBetweenNodeAndItsAncestor {
    /**
     * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
     *  （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
     *  示例 1：
     *  1026.jpg
     * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
     * 输出：7
     * 解释：
     * 我们有大量的节点与其祖先的差值，其中一些如下：
     * |8 - 3| = 5
     * |3 - 7| = 4
     * |8 - 1| = 7
     * |10 - 13| = 3
     * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
     *  示例 2：
     * 输入：root = [1,null,2,null,0,3]
     * 输出：3
     *  提示：
     *  树中的节点数在 2 到 5000 之间。
     *  0 <= Node.val <= 105
     *
     *  一次过
     *  		执行耗时:122 ms,击败了11.21% 的Java用户
     * 			内存消耗:39.4 MB,击败了5.01% 的Java用户
     */
    int max=0;
    public int maxAncestorDiff(TreeNode root) {
        //队列进入下一层加，回到上一层减
        Deque<Integer> path=new LinkedList<>();
        if(root==null){
            return 0;
        }
        path.offerLast(root.val);
        record(root,path);
        return max;
    }

    private void record(TreeNode root, Deque<Integer> path) {
        //计算最大差值
        for (Integer integer : path) {
            max=Math.max(Math.abs(integer-root.val),max);
        }
        if(root.left!=null){
            path.offerLast(root.left.val);
            record(root.left,path);
            path.pollLast();
        }
        if(root.right!=null){
            path.offerLast(root.right.val);
            record(root.right,path);
            path.pollLast();
        }
    }
}
