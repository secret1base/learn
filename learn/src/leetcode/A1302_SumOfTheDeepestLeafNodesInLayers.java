package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/08/19
 */
public class A1302_SumOfTheDeepestLeafNodesInLayers {
    /**
     * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
     *  示例 1：
     *  1302.png
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     *  示例 2：
     * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
     * 输出：19
     *  提示：
     *  树中节点数目在范围 [1, 104] 之间。
     *  1 <= Node.val <= 100
     *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
     *
     *  		执行耗时:5 ms,击败了45.67% 的Java用户
     * 			内存消耗:39.3 MB,击败了86.15% 的Java用户
     */
    public int deepestLeavesSum(TreeNode root) {
        //进行层序遍历，每执行一次刷新一次和
        int sum=0;
        Deque<TreeNode> path=new LinkedList<>();
        if(root==null){
            return sum;
        }
        path.offerLast(root);
        while (!path.isEmpty()){
            int size = path.size();
            //初始化sum
            sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = path.pollFirst();
                sum+=node.val;
                if(node.left!=null){
                    path.offerLast(node.left);
                }
                if(node.right!=null){
                    path.offerLast(node.right);
                }
            }
        }
        return sum;
    }
}
