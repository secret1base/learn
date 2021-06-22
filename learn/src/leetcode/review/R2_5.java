package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R2_5 {
    /**
     * 			执行耗时:2 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.7 MB,击败了61.05% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode hair=new ListNode();
        ListNode node=hair;
        while (l1!=null||l2!=null||carry!=0){
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            int i = x + y + carry;
            node.next=new ListNode(i%10);
            node=node.next;
            carry=i/10;
        }
        return hair.next;
    }
}
