package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R21_4 {
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:37.8 MB,击败了70.76% 的Java用户
    //不要轻易断开节点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                node.next=l2;
                node=node.next;
                l2=l2.next;
            }else{
                node.next=l1;
                node=node.next;
                l1=l1.next;
            }
        }
        if(l1 != null){
            node.next=l1;
        }
        if(l2 != null){
            node.next=l2;
        }
        return hair.next;
    }
}
