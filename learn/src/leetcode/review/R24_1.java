package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/16
 */
public class R24_1 {
    //输入：head = [1,2,3,4]
    //输出：[2,1,4,3]

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.2 MB,击败了24.68% 的Java用户
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        while (node!=null&&node.next!=null&&node.next.next != null){
            ListNode two = node.next;
            ListNode one = two.next;
            ListNode three = one.next;
            node.next=one;
            one.next=two;
            two.next=three;
            node=two;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode listNode = new R24_1().swapPairs(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
