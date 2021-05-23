package leetcode;

import leetcode.tool.TreeNode;

/**
 * 110.平衡二叉树
 * @author: wyj
 * @date: 2021/05/19
 */
public class A110_BalancedBinaryTree {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *  本题中，一棵高度平衡二叉树定义为：
     *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *  示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     *  示例 2：
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     *  示例 3：
     * 输入：root = []
     * 输出：true
     *  提示：
     *  树中的节点数在范围 [0, 5000] 内
     *  -104 <= Node.val <= 104
     */
    /**
     * 解答成功: 执行耗时:1 ms,击败了99.99% 的Java用户 内存消耗:38.7 MB,击败了21.29% 的Java用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
        int i = checkBalanced(root, 0);
        return i!=-1;
    }

    private int checkBalanced(TreeNode root, int level) {
        if(root==null){
            return level;
        }
        int a = checkBalanced(root.left, level + 1);
        int b = checkBalanced(root.right, level + 1);
        if(a==-1||b==-1||Math.abs(a-b)>1){
            //如果a-b的绝对值大于1，说明左右子节点层数差距大于1，或者任意一个值为-1那也是不符合的
            return -1;
        }else{
            return Math.max(a,b);
        }
    }
    /**
     *     boolean flag=true;
     *     public boolean isBalanced(TreeNode root) {
     *         getLength(root);
     *         return flag;
     *     }
     *
     *     private int getLength(TreeNode root) {
     *         if(root==null||!flag){
     *             return 0;
     *         }
     *         int left=getLength(root.left);
     *         int right=getLength(root.right);
     *         if(Math.abs(right-left)>1){
     *             flag=false;
     *             //结束循环
     *             return 0;
     *         }else{
     *             return Math.max(left,right)+1;
     *         }
     *     }
     */
}
