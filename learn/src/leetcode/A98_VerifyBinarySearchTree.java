package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * @author: wyj
 * @date: 2021/05/31
 */
public class A98_VerifyBinarySearchTree {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *  假设一个二叉搜索树具有如下特征：
     *  节点的左子树只包含小于当前节点的数。
     *  节点的右子树只包含大于当前节点的数。
     *  所有左子树和右子树自身必须也是二叉搜索树。
     *  示例 1:
     *  输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *  示例 2:
     *  输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * 通过中序遍历获取到的值,可以保证是先左子节点在父节点再右子节点
     * 			执行耗时:2 ms,击败了27.66% 的Java用户
     * 			内存消耗:38.2 MB,击败了22.74% 的Java用户
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        doRecord(root,list);
        for(int i=0;i<list.size();i++){
            if(i+1<list.size()&&list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    private void doRecord(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        doRecord(root.left,list);
        list.add(root.val);
        doRecord(root.right, list);
    }
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(7);
        a1.left=a2;
        a1.right=a3;
        a3.left=a4;
        a3.right=a5;
        boolean validBST = new A98_VerifyBinarySearchTree().isValidBST(a1);
        System.out.println(validBST);
        /**
         *    5
         *  4   6
         *     3  7
         *  不是二叉搜索树 因为5比3小
         */
    }
}
