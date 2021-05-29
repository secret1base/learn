package leetcode;

import leetcode.tool.ListNode;

/**
 * 83.删除排序链表中的重复元素
 * @author: wyj
 * @date: 2021/05/27
 */
public class A83_DeleteTheDuplicateElementsInTheSortedList {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *  返回同样按升序排列的结果链表。
     *  示例 1：
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *  示例 2：
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     * @param head
     * @return
     */
    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(1);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        ListNode listNode = new A83_DeleteTheDuplicateElementsInTheSortedList().deleteDuplicates(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.8 MB,击败了67.60% 的Java用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        while (node!=null){
            if(node.next!=null){
                ListNode next = node.next;
                if(node.val==next.val){
                    while (next.next!=null&&next.next.val == next.val){
                        next=next.next;
                    }
                    node.next=next.next;
                }
            }
            node=node.next;
        }
        return head;
    }
}
