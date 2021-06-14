package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R2_4 {
    //			执行耗时:2 ms,击败了100.00% 的Java用户
    //			内存消耗:38.7 MB,击败了68.18% 的Java用户
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            int a=l1==null?0:l1.val;
            int b=l2==null?0:l2.val;
            int i = a + b + carry;
            node.next=new ListNode(i%10);
            carry=i/10;
            node=node.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return hair.next;
    }
}
