package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R25_2 {
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
        ListNode listNode = new R25_2().reverseKGroup(a1, 3);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        int index=1;
        ListNode pre=node;
        while (node!=null){
            if(index==k){
                if(node.next==null){
                    break;
                }
                ListNode end = node.next;
                ListNode after=null;
                if(end!=null){
                    after = end.next;
                    end.next=null;
                }
                ListNode currHead = pre.next;
                ListNode newHead= reverse(currHead);
                pre.next=newHead;
                currHead.next=after;
                //初始化
                pre=currHead;
                index=1;
                node=pre;
            }else{
                index++;
                node=node.next;
            }
        }
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
