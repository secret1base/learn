package leetcode;

import leetcode.tool.ListNode;

/**
 * 206. 反转链表
 * @author: wyj
 * @date: 2021/05/14
 */
public class A206_ReverseLinkedList {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *  示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *  示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     *  示例 3：
     * 输入：head = []
     * 输出：[]
     *  提示：
     *  链表中节点的数目范围是 [0, 5000]
     *  -5000 <= Node.val <= 5000
     *  进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     * @param head
     * @return
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
        a4.next=a5;
        ListNode listNode = new A206_ReverseLinkedList().reverseList(a1);
        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        System.out.println(listNode.val);
    }

    /**
     * 迭代
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了81.45% 的Java用户
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        ListNode curr=head;
//        ListNode pre=null;
//        while (curr!=null){
//            ListNode next = curr.next;
//            curr.next=pre;
//            pre=curr;
//            curr=next;
//        }
//        return pre;
//    }

    /**
     * 递归
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38 MB,击败了88.06% 的Java用户
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if(head==null||head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }


}
