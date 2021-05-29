package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R143_2 {
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

    /**
     * 			执行耗时:6 ms,击败了10.69% 的Java用户
     * 			内存消耗:41.1 MB,击败了46.82% 的Java用户
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        for(int i = 0; i < list.size()/2;i++){
            ListNode listNode = list.get(i);
            ListNode next = list.get(list.size()-1-i);
            next.next=null;
            ListNode after = listNode.next;
            listNode.next=next;
            next.next=after;
            if(i==list.size()/2-1){
                after.next=null;
            }
        }
    }
}
