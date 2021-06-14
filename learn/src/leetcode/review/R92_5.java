package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/02
 */
public class R92_5 {
    //输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36 MB,击败了59.43% 的Java用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        ListNode pre=node;
        ListNode after=null;
        int index=1;
        while (node != null) {
            if(index==left){
                pre=node;
            }else if(index==right){
                ListNode rightNode = node.next;
                if(rightNode != null){
                    after= rightNode.next;
                    rightNode.next=null;
                }
                ListNode tmpHead = pre.next;
                pre.next= reverse(tmpHead);
                tmpHead.next=after;
                return hair.next;
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
