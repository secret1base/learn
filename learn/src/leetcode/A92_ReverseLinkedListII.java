package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.TreeNode;

import java.util.Stack;

/**
 * 92.反转链表 II
 * @author: wyj
 * @date: 2021/05/17
 */
public class A92_ReverseLinkedListII {
    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
     * 表节点，返回 反转后的链表 。
     *  示例 1：
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     *  示例 2：
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     */
    public static void main(String[] args) {
//        ListNode a=new ListNode(1);
//        ListNode b=new ListNode(2);
//        ListNode c=new ListNode(3);
//        ListNode d=new ListNode(4);
//        ListNode e=new ListNode(5);
//        a.next=b;
//        b.next=c;
//        c.next=d;
//        d.next=e;
//        ListNode listNode = new A92_ReverseLinkedListII().reverseBetween(a, 2, 4);
//        ListNode listNode = new A92_ReverseLinkedListII().reverseBetween(new ListNode(5), 1, 1);
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(5);
        a.next=b;
        ListNode listNode = new A92_ReverseLinkedListII().reverseBetween(a, 1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 容易搞混
     * 解题思路
     * 92.png
     * 注意切断连接
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.9 MB,击败了84.72% 的Java用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode pre=hair;
        //找到前一个节点
        for(int i=1;i<left;i++){
            pre=pre.next;
        }
        //找到right节点
        ListNode rightNode=pre;
        for (int i=0;i<right-left+1;i++){
            rightNode=rightNode.next;
        }
        //这个是后续要接上的尾节点
        ListNode next = rightNode.next;
        //切断
        rightNode.next=null;
        //这个是未来的尾节点，暂时是头节点
        ListNode end = pre.next;
        reverse(end);
        pre.next=rightNode;
        end.next=next;
        return hair.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
