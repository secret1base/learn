package leetcode;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [剑指 Offer 36]二叉搜索树与双向链表
 * @author: wyj
 * @date: 2021/06/11
 */
public class A10036_BinarySearchTreeAndBidirectionalLinkedList {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *  为了让您更好地理解问题，以下面的二叉搜索树为例：
     * 10036(1).png
     *  我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     *
     *  下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     * 10036(2).png
     *  特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
     *  注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
     * @param root
     * @return
     */
    /**
     * 这种解法更容易理解，下面的解法虽然高效，但是难理解，并在需要解题的情况下很难直接解除，需要进行推算
     * 			执行耗时:1 ms,击败了16.84% 的Java用户
     * 			内存消耗:37.9 MB,击败了23.39% 的Java用户
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;
        }
        List<TreeNode> list=new ArrayList<>();
        record(root,list);
        //左前右后
        for (int i=0;i<list.size();i++){
            TreeNode cur = list.get(i);
            if(i==0){
                //前驱
                cur.left=list.get(list.size()-1);
                //后继
            }else{
                cur.left=list.get(i-1);
            }
            if(i+1<list.size()){
                cur.right=list.get(i+1);
            }else{
                cur.right=list.get(0);
            }
        }
        return list.get(0);
    }

    private void record(TreeNode root, List<TreeNode> list) {
        if(root==null){
            return;
        }
        record(root.left, list);
        list.add(root);
        record(root.right, list);
    }

//    /**
//     * 解题思路:10036.zip
//     * 			执行耗时:0 ms,击败了100.00% 的Java用户
//     * 			内存消耗:37.8 MB,击败了47.58% 的Java用户
//     * @param root
//     * @return
//     */
//    public TreeNode treeToDoublyList(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        record(root);
//        pre.right = head;
//        head.left=pre;
//        return root;
//    }
//    TreeNode pre=null;
//    TreeNode head=null;
//    private void record(TreeNode curr) {
//        if(curr==null){
//            return;
//        }
//        record(curr.left);
//        if(pre!=null){
//            pre.right=curr;
//        }else{
//            head=curr;
//        }
//        curr.left=pre;
//        pre=curr;
//        record(curr.right);
//    }



}
