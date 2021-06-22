package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 328. 奇偶链表
 * @author: wyj
 * @date: 2021/06/17
 */
public class A328_OddAndEvenList {
    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *  请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *  示例 1:
     *  输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     *  示例 2:
     *  输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     */
    /**
     * 这题是经过不断调试做出来的，直接解答出答案比较困难
     * 			执行耗时:1 ms,击败了6.91% 的Java用户
     * 			内存消耗:38.2 MB,击败了31.30% 的Java用户
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode node=head;
        //奇数的最后一个值
        ListNode after=null;
        //0奇数
        boolean ji=true;
        //找到奇数的最后一个值
        while (node!=null){
            if(ji){
                after=node;
            }
            node=node.next;
            ji=!ji;
        }
        ListNode finish=after;
        ListNode end=after.next;
        node=head;
        //把所有奇数连接到当前节点后面，把偶数连接到after后面
        while (node != null&&node.next!=null&&node.next.next!=null) {
            //偶数
            ListNode event = node.next;
            //奇数
            ListNode odd = event.next;
            node.next=odd;//后面连接奇数
            after.next=event;//后面连接偶数
            //断开
            event.next=null;
            after=event;
            node=odd;
            if(node==finish){
                break;
            }
        }
        after.next=end;
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(4);
//        ListNode a5 = new ListNode(5);
        a1.next=a2;
//        a2.next=a3;
//        a3.next=a4;
//        a4.next=a5;
        ListNode listNode = new A328_OddAndEvenList().oddEvenList(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
