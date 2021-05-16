package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/14
 */
public class R206_1 {
    private ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr = next;
        }
        return pre;
    }

//    private ListNode reverseList(ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode pre = reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return pre;
//    }
}
