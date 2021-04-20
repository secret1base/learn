package leetcode;

import leetcode.tool.ListNode;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * @author: wyj
 * @date: 2021/04/20
 */
public class A24_ExchangeTheNodesInTheLinkedList {
    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 24.jpg
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp=head;
        for (int i=2;i<5;i++) {
            tmp.next=new ListNode(i);
            tmp=tmp.next;
        }
        new A24_ExchangeTheNodesInTheLinkedList().swapPairs(head);
    }

    /**
     * 根据递归的逻辑每次先交换1、2节点的位置，接着返回2节点
     * 然后把3节点传入递归，那么预期会返回4节点，
     * 接着把4节点绑定到1节点后面
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了44.07%的用户
     */
    public ListNode swapPairs(ListNode head) {
        //1234
        ListNode pre=head;
        //判空处理
        if(head==null){
            return head;
        }
        //2
        ListNode next = pre.next;
        //判空处理
        if(next==null){
            return pre;
        }
        //3
        ListNode nextNext = next.next;
        //2后面绑定1
        next.next=pre;
        //把3传入递归，预期会返回3交换位置后的4，把4绑定到1后面
        pre.next = swapPairs(nextNext);
        //返回当前的头部节点
        return next;
    }
}
