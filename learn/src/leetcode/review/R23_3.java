package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R23_3 {
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//			执行耗时:332 ms,击败了5.07% 的Java用户
//			内存消耗:40.2 MB,击败了44.12% 的Java用户
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        while (true){
            ListNode min=null;
            int current=-1;
            for (int i=0;i<lists.length;i++){
                if(lists[i]==null){
                    continue;
                }
                if(min==null){
                    min=lists[i];
                    current=i;
                }else if(min.val>lists[i].val){
                    min=lists[i];
                    current=i;
                }
            }
            if(current!=-1){
                node.next=min;
                node=node.next;
                lists[current]=min.next;
            }else{
                return hair.next;
            }
        }
    }
}
