package leetcode.review;

import leetcode.tool.ListNode;
import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R92_1 {
    //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = new R92_1().reverseBetween(a, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:36.3 MB,击败了10.47% 的Java用户

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode node = hair;
        ListNode pre = null;
        ListNode after = null;
        int index = 1;
        while (node != null) {
            if (index == left) {
                pre = node;
            }
            if (index == right) {
                //这时node在right前面
                break;
            }
            index++;
            node = node.next;
        }
        if (node.next != null) {
            ListNode rightNode = node.next;
            after = rightNode.next;
            rightNode.next = null;//断开节点
        }
        ListNode leftNode = pre.next;
        ListNode currHead = doreverse(leftNode);
        pre.next = currHead;
        leftNode.next = after;
        return hair.next;
    }

    private ListNode doreverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}