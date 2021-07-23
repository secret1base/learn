package leetcode;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * @author: wyj
 * @date: 2021/07/15
 */
public class A437_PathSummationIII {
    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     *  找出路径和等于给定数值的路径总数。
     *  路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *  二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *  示例：
     *  root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     * 返回 3。和等于 8 的路径有:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * 重点是限制每个节点只有第一次是作为起始节点
     * 			执行耗时:316 ms,击败了5.12% 的Java用户
     * 			内存消耗:39.5 MB,击败了5.05% 的Java用户
     */
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        //用于限制每个节点作为起始节点只能一次
        Map<String,Integer> map=new HashMap<>();
        if(root==null){
            return count;
        }
        map.put(root.toString(),1);
        record(root,root.val,targetSum,map);
        return count;
    }

    private void record(TreeNode root, int sum, int targetSum, Map<String, Integer> map) {
        if(sum==targetSum){
            count++;
        }
        if(root.left!=null){
            if(map.get(root.left.toString())==null){
                //限制每个节点作为起始节点只能一次
                map.put(root.left.toString(),1);
                record(root.left,root.left.val,targetSum, map);
            }
            record(root.left,sum+root.left.val,targetSum, map);
        }
        if(root.right!=null){
            if(map.get(root.right.toString())==null){
                //限制每个节点作为起始节点只能一次
                map.put(root.right.toString(),1);
                record(root.right,root.right.val,targetSum, map);
            }
            record(root.right,sum+root.right.val,targetSum, map);
        }
    }

    public static void main(String[] args) {
        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(2);
        TreeNode a3=new TreeNode(3);
        TreeNode a4=new TreeNode(4);
        a1.left=a2;
        a2.left=a3;
        a3.left=a4;
        int sum = new A437_PathSummationIII().pathSum(a1, 3);
        System.out.println(sum);
    }
}
