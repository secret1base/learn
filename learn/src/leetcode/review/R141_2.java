package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R141_2 {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.5 MB,击败了60.56% 的Java用户
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
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
    }
}
