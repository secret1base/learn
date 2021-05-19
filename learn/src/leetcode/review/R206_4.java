package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/18
 */
public class R206_4 {
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38.1 MB,击败了82.49% 的Java用户
    private ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr = next;
        }
        return pre;
    }
}
