package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * @author: wyj
 * @date: 2021/07/13
 */
public class A109_BinarySearchTreeTransformedFromOrderedList {
    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *  本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *  示例:
     *  给定的有序链表： [-10, -3, 0, 5, 9],
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     *  		执行耗时:1 ms,击败了56.82% 的Java用户
     * 			内存消耗:39.7 MB,击败了35.68% 的Java用户
     *
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        //二分法进行实现(一开始没想起来)
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int left=0;
        int right=list.size()-1;
        return addNode(left,right,list);

    }

    private TreeNode addNode(int left, int right, List<Integer> list) {
        int mid = left + (right - left) / 2;
        TreeNode node=new TreeNode(list.get(mid));
        if(mid>left){
            node.left=addNode(left,mid-1,list);
        }
        if(mid<right){
            node.right=addNode(mid+1,right,list);
        }
        return node;
    }

}
