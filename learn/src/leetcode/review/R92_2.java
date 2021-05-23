package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/20
 */
public class R92_2 {
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        ListNode listNode = new R92_2().reverseBetween(a, 2, 4);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        ListNode pre=null;
        int index=1;
        while (node!=null){
            if(index==left){
                pre=node;
            }
            if(index==right){
                //此时node=rightNode的上一个节点
                break;
            }
            node=node.next;
            index++;
        }
        ListNode afterNode=null;
        if(node!=null&&node.next!=null){
            afterNode = node.next.next;
            node.next.next=null;//断开
        }
        ListNode newFoot = pre.next;
        ListNode newHead= reverse(newFoot);
        pre.next=newHead;
        newFoot.next=afterNode;
        return hair.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
