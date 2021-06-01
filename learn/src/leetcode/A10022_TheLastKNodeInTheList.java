package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * @author: wyj
 * @date: 2021/06/01
 */
public class A10022_TheLastKNodeInTheList {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *  例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *  示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     * @param head
     * @param k
     * @return
     */
    /**
     * 		执行耗时:1 ms,击败了11.77% 的Java用户
     * 		内存消耗:36.4 MB,击败了22.74% 的Java用户
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        return list.get(list.size()-k);
    }
}
