package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R141_1 {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.8 MB,击败了13.78% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (true){
            if(fast==null||fast.next==null){
                return false;
            }
            fast = fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
    }
}
