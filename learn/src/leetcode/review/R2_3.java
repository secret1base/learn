package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R2_3 {
    public static void main(String[] args) {
        new R2_3().addTwoNumbers(new ListNode(2),new ListNode(3));
    }

    /**
     * 			执行耗时:2 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.7 MB,击败了73.92% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        int carry=0;
        while (l1!=null||l2 != null||carry!=0){
            int a=l1!=null?l1.val:0;
            int b=l2!=null?l2.val:0;
            int i = a + b + carry;
            node.next=new ListNode(i%10);
            carry=i/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            node=node.next;
        }
        return hair.next;
    }
}
