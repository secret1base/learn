package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R23_2 {
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6

    /**
     * 			执行耗时:303 ms,击败了8.49% 的Java用户
     * 			内存消耗:40.2 MB,击败了48.34% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        while (true){
            int min=Integer.MAX_VALUE;
            int i=-1;
            for (int k=0;k<lists.length;k++) {
                ListNode n = lists[k];
                if(n!=null&&n.val<min){
                    i=k;
                    min=n.val;
                }
            }
            if(i==-1){
                return hair.next;
            }else{
                ListNode curr = lists[i];
                ListNode next = curr.next;
                lists[i]=next;
                curr.next=null;
                node.next=curr;
                node=node.next;
            }
        }
    }
}
