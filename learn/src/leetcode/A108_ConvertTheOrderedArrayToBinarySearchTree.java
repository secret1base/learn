package leetcode;

import leetcode.tool.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author: wyj
 * @date: 2021/06/30
 */
public class A108_ConvertTheOrderedArrayToBinarySearchTree {
    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *  高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *  示例 1：
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *  示例 2：
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.3 MB,击败了32.90% 的Java用户
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //题目要求为高度平衡的二叉搜索树，因此通过二分法分配节点
        int begin=0;
        int end=nums.length-1;
        return addNode(begin,end,nums);
    }

    private TreeNode addNode(int begin, int end, int[] nums) {
        int mid = begin + (end - begin) / 2;
        TreeNode node=new TreeNode(nums[mid]);
        //判断是否存在左节点123 0 2 1
        if(mid-1>=begin){
            node.left=addNode(begin,mid-1,nums);
        }
        //判断是否存在右节点
        if(mid+1<=end){
            node.right=addNode(mid+1,end,nums);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new A108_ConvertTheOrderedArrayToBinarySearchTree().sortedArrayToBST(new int[]{1, 2, 3,4,5,6,7,8});
        System.out.println(node);

    }
}
