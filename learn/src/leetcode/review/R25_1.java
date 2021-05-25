package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R25_1 {
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
        ListNode listNode = new R25_1().reverseKGroup(a1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.8 MB,击败了27.59% 的Java用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        ListNode pre=hair;
        int i=1;
        while (node != null) {
            if(i==k){
                if(node.next !=null){
                    ListNode right = node.next;
                    ListNode after = right.next;
                    right.next=null;
                    ListNode left = pre.next;
                    ListNode newHead= reverse(left);
                    pre.next=newHead;
                    left.next=after;
                    pre=left;
                    node=pre;
                    i=1;
                }else{
                    break;
                }
            }else{
                node=node.next;
                i++;
            }
        }
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
