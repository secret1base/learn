package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R92_4 {
    //输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.8 MB,击败了89.90% 的Java用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        int index=1;
        ListNode pre=null;
        ListNode after=null;
        while (node!=null){
            if(index==left){
                pre=node;
            }else if(index==right){
                if(node.next!=null){
                    ListNode rightNode = node.next;
                    after=rightNode.next;
                    rightNode.next=null;
                    ListNode leftNode = pre.next;
                    pre.next=reverse(leftNode);
                    leftNode.next=after;
                    return hair.next;
                }
            }
            index++;
            node=node.next;
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
