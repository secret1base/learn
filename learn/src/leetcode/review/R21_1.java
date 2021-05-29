package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R21_1 {
    /**
     * 			执行耗时:1 ms,击败了25.99% 的Java用户
     * 			内存消耗:37.7 MB,击败了78.90% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair=new ListNode();
        ListNode curr=hair;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                ListNode next = l2.next;
                l2.next=null;
                curr.next=l2;
                l2=next;
                curr=curr.next;
            }else{
                ListNode next = l1.next;
                l1.next=null;
                curr.next=l1;
                l1=next;
                curr=curr.next;
            }
        }
        if (l1!=null){
            curr.next=l1;
        }
        if (l2!=null){
            curr.next=l2;
        }
        return hair.next;
    }
}
