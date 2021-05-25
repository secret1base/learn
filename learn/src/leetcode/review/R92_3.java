package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R92_3 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair=new ListNode();
        hair.next=head;
        //反转节点的前一个节点
        ListNode pre=null;
        //反转节点的后一个节点
        ListNode after=null;
        ListNode node=hair;
        int index=1;
        while (node!=null){
            if(index==left){
                pre=node;
            }
            if(index==right){
                //这时node为截至节点的前一个节点
                break;
            }
            index++;
            node=node.next;
        }
        //断开右节点，并且把后续节点取出来
        ListNode rightNode = node.next;
        if(rightNode.next != null){
            after = rightNode.next;
            rightNode.next=null;
        }
        ListNode leftNode = pre.next;
        ListNode curr= reverse(leftNode);
        pre.next=curr;
        leftNode.next=after;
        return hair.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
