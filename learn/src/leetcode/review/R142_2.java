package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/18
 */
public class R142_2 {
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。


    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode index=null;
        while (true){
            if(fast==null||fast.next == null){
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
            slow=slow.next;
            index=index.next;
        }
        return index;
    }
}
