package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R141_4 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
