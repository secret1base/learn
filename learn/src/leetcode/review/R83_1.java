package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R83_1 {
    //输入：head = [1,1,2,3,3]
    //输出：[1,2,3]

    /**
     * 			执行耗时:1 ms,击败了34.91% 的Java用户
     * 			内存消耗:37.8 MB,击败了68.31% 的Java用户
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        while (node!=null){
            ListNode next=node.next;
            while (next!=null&&node.val==next.val){
                next=next.next;
            }
            node.next=next;
            node=node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(3);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode listNode = new R83_1().deleteDuplicates(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
