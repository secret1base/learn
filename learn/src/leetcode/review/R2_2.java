package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R2_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            Integer left = l1==null?0:l1.val;
            Integer right = l2==null?0:l2.val;
            int i = left + right+carry;
            if(i>=10){
                i=i-10;
                carry=1;
            }else{
                carry=0;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            node.next=new ListNode(i);
            node=node.next;
        }
        return hair.next;
    }
}
