package leetcode;

import leetcode.tool.ListNode;

/**
 * 203. 移除链表元素
 * @author: wyj
 * @date: 2021/07/21
 */
public class A203_RemoveLinkedListElements {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *  示例 1：
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     *  示例 2：
     * 输入：head = [], val = 1
     * 输出：[]
     *  示例 3：
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     *  提示：
     *  列表中的节点数目在范围 [0, 104] 内
     *  1 <= Node.val <= 50
     *  0 <= val <= 50
     *
     *  		执行耗时:1 ms,击败了99.32% 的Java用户
     * 			内存消耗:39.5 MB,击败了17.86% 的Java用户
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=new ListNode();
        pre.next=head;
        ListNode node=pre;
        while (node!=null){
            ListNode next = node.next;
            if(next!=null&&next.val==val){
                node.next=next.next;
                continue;
            }else{
                node=next;
            }
        }
        return pre.next;
    }
}
