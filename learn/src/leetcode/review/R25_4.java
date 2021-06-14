package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R25_4 {
    //输入：head = [1,2,3,4,5], k = 2
    //输出：[2,1,4,3,5]
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38.9 MB,击败了12.31% 的Java用户
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        int index=1;
        ListNode pre=node;
        ListNode after=null;
        while (node!=null){
            if(index==k){
                if(node.next!=null){
                    after=node.next.next;
                    node.next.next=null;
                }else{
                    break;
                }
                ListNode next = pre.next;
                pre.next= reverse(next);
                next.next=after;
                node=next;
                pre=node;
                index=1;
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
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }

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
        ListNode listNode = new R25_4().reverseKGroup(a1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
