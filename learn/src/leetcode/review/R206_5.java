package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R206_5 {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
