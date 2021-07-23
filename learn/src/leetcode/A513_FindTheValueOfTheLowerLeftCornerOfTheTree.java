package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * @author: wyj
 * @date: 2021/07/19
 */
public class A513_FindTheValueOfTheLowerLeftCornerOfTheTree {
    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *  假设二叉树中至少有一个节点。
     *  示例 1:
     *  513(1).jpg
     * 输入: root = [2,1,3]
     * 输出: 1
     *  示例 2:
     *  513(2).jpg
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     * 			执行耗时:1 ms,击败了74.17% 的Java用户
     * 			内存消耗:38 MB,击败了62.65% 的Java用户
     */
    public int findBottomLeftValue(TreeNode root) {
        //最底层、最左边
        Deque<TreeNode> path=new LinkedList<>();
        path.offerLast(root);
        TreeNode bottomLeft=null;
        while (!path.isEmpty()){
            int size = path.size();
            for (int i=0;i<size;i++){
                TreeNode node = path.pollFirst();
                if(i==0){
                    bottomLeft=node;
                }
                if(node.left!=null){
                    path.offerLast(node.left);
                }
                if(node.right!=null){
                    path.offerLast(node.right);
                }
            }
        }
        return bottomLeft.val;
    }
}
