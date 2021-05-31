package leetcode;

import leetcode.tool.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * @author: wyj
 * @date: 2021/05/31
 */
public class A82_DeleteDuplicateElementsInSortedListII {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     *  返回同样按升序排列的结果链表。
     *  示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *  示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *  提示：
     *  链表中节点数目在范围 [0, 300] 内
     *  -100 <= Node.val <= 100
     *  题目数据保证链表已经按升序排列
     */
    /**
     * 新建一个头节点hair，每次循环检查后面两个节点a、b的值是否相等，相等则让b节点向后移动一位继续检测
     * 一直到a!=b时，将hair的后面一个节点连接上b，然后(不执行node=node.next，因为b节点可能与后面的节点是重复的，需要重新检测)重新开始循环
     * 			执行耗时:1 ms,击败了73.01% 的Java用户
     * 			内存消耗:37.9 MB,击败了46.30% 的Java用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        while (node!=null&&node.next != null&&node.next.next != null){
            if(node.next.val==node.next.next.val){
                ListNode next=node.next.next;
                while (next != null&&node.next.val == next.val) {
                    next=next.next;
                }
                node.next=next;
                //回到开始位置重新检测
                continue;
            }
            node=node.next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode listNode = new A82_DeleteDuplicateElementsInSortedListII().deleteDuplicates(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
