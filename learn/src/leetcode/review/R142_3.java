package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R142_3 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode index=null;
        while (true){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                index=head;
                break;
            }
        }
        while (slow!=index){
            index=index.next;
            slow=slow.next;
        }
        return index;
    }
}
