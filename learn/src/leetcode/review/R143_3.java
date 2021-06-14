package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R143_3 {
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
//		执行耗时:4 ms,击败了33.58% 的Java用户
//		内存消耗:40.9 MB,击败了71.58% 的Java用户
    public void reorderList(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        ListNode node=head;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int size = list.size();
        int mid = size / 2;
        for (int i=0;i<mid;i++){
            ListNode pre = list.get(i);
            ListNode next = list.get(size - i - 1);
            ListNode after = pre.next;
            pre.next=next;
            next.next=null;
            next.next=after;
            if(after.next==next){
                after.next=null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        new R143_3().reorderList(a1);
        while (a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }

    }
}
