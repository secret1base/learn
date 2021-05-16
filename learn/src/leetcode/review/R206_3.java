package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R206_3 {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.5 MB,击败了19.63% 的Java用户
     * @param head
     * @return
     */
    public ListNode re(ListNode head){
        ListNode curr=head;
        ListNode pre=null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.3 MB,击败了47.31% 的Java用户
     * @param head
     * @return
     */
    public ListNode re2(ListNode head){
        if(head == null||head.next == null){
            return head;
        }
        ListNode listNode = re2(head.next);
        head.next.next=head;
        head.next=null;
        return listNode;
    }
}
