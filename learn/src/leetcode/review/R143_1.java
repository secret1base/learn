package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R143_1 {
    //给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
// 示例 1:
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
// 示例 2:
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        new R143_1().reorderList(a1);
        while (a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }
    }

    /**
     * 			执行耗时:4 ms,击败了33.20% 的Java用户
     * 			内存消耗:40.7 MB,击败了87.43% 的Java用户
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode node=head;
        List<ListNode> list=new ArrayList<>();
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int mid = list.size() / 2;//5/2=2 0 1 2 3 4 4/2=2 0 1 2 3
        // 1 2 3 4 5
        // 1 2 3 4
        list.get(mid).next=null;
        for (int i=0;i<mid;i++){
            ListNode pre = list.get(i);
            ListNode after = pre.next;
            ListNode next = list.get(list.size() - 1 - i);
            next.next=null;
            pre.next=next;
            if(next!=after){
                next.next=after;
            }
        }
    }
}
