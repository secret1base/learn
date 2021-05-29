package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R25_3 {
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
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
    ListNode listNode = new R25_3().reverseKGroup(a1, 2);
    while (listNode!=null){
        System.out.println(listNode.val);
        listNode=listNode.next;
    }
}

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.9 MB,击败了8.90% 的Java用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        ListNode pre=node;
        int index=1;
        while (node!=null){
            if(index==k){
                if(node.next!=null){
                    ListNode after=null;
                    ListNode curr = node.next;
                    after=curr.next;
                    curr.next=null;
                    ListNode next = pre.next;
                    pre.next= reverse(next);
                    next.next=after;
                    node=next;
                    pre=node;
                    index=1;
                }else{
                    break;
                }
            }else{
                node=node.next;
                index++;
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
}
