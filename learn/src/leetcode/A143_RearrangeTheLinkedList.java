package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class A143_RearrangeTheLinkedList {
    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *  示例 1:
     *  给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     *  示例 2:
     *  给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * @param head
     */
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
//        a4.next=a5;
        new A143_RearrangeTheLinkedList().reorderList(a1);
        while (a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }
    }

    /**
     * 			执行耗时:6 ms,击败了10.72% 的Java用户
     * 			内存消耗:41 MB,击败了64.24% 的Java用户
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode next=head.next;
        list.add(head);
        while (next != null){
            list.add(next);
            next=next.next;
        }
        Stack<ListNode> path=new Stack<>();
        int mid=list.size()/2;
        for(int i = mid; i < list.size(); i++){
            ListNode listNode = list.get(i);
            listNode.next=null;
            path.push(listNode);
        }
        for(int i=0;i<mid&&!path.isEmpty();i++){
            ListNode pop = path.pop();
            ListNode listNode = list.get(i);
            if(pop==listNode.next){
                //避免listNode=2 2接3 3后面再接3这种情况
                break;
            }
            ListNode after = listNode.next;
            listNode.next=pop;
            pop.next=after;
        }
    }


}
