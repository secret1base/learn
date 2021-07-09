package leetcode;

import leetcode.review.R25_3;
import leetcode.tool.ListNode;

/**
 * 86. 分隔链表
 * @author: wyj
 * @date: 2021/06/24
 */
public class A86_SeparateLinkedList {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *  你应当 保留 两个分区中每个节点的初始相对位置。
     *  示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *  示例 2：
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * 解题思路
     * 先分成两个节点一个只存放小的，一个只存放大的，然后将两个节点进行连接
     * 调试比较多，解题思路还是很明确的
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:37.8 MB,击败了34.49% 的Java用户
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode hair=new ListNode();
        ListNode pre=hair;
        ListNode node=head;
        ListNode after=null;
        ListNode afterNode=null;
        while (node!=null){
            if(node.val<x){
                pre.next=node;
                pre=pre.next;
            }else{
                if(after==null){
                    after=node;
                    afterNode=after;
                }else{
                    afterNode.next=node;
                    afterNode=afterNode.next;
                }
            }
            node=node.next;
        }
        pre.next=after;
        if(afterNode!=null){
            afterNode.next=null;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(2);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        ListNode listNode = new A86_SeparateLinkedList().partition(a1, 3);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
