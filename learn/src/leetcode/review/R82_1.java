package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R82_1 {
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//		执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:37.9 MB,击败了57.22% 的Java用户
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        while (node!=null){
            if(node.next!=null&&node.next.next!=null&&node.next.val==node.next.next.val){
                //如果后两个节点相同，向后查找不同的节点
                ListNode next=node.next.next;
                while (next!=null&&next.val==node.next.val){
                    next=next.next;
                }
                node.next=next;
            }else{
                node=node.next;
            }
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        a6.next=a7;
        ListNode listNode = new R82_1().deleteDuplicates(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
