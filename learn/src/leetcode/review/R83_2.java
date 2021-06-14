package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/10
 */
public class R83_2 {
    //			执行耗时:1 ms,击败了34.93% 的Java用户
    //			内存消耗:37.9 MB,击败了59.12% 的Java用户
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        while (node!=null){
            if(node.next!=null&&node.next.next!=null&&node.next.val==node.next.next.val){
                ListNode next=node.next;
                while (next!=null&&next.val==node.next.val){
                    next=next.next;
                }
                node=node.next;
                node.next=next;
            }else{
                node=node.next;
            }
        }
        return hair.next;
    }

}
