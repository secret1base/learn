package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R206_2 {
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//    public ListNode reverseList(ListNode head) {
//        ListNode curr=head;
//        ListNode pre=null;
//        while (curr!=null){
//            ListNode next = curr.next;
//            curr.next=pre;
//            pre=curr;
//            curr=next;
//        }
//        return pre;
//    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return pre;
    }
}
