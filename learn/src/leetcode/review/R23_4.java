package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R23_4 {
    /**
     * 			执行耗时:310 ms,击败了7.49% 的Java用户
     * 			内存消耗:39.8 MB,击败了86.18% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre=new ListNode();
        ListNode node=pre;
        while (true){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for (int i=0;i<lists.length;i++) {
                ListNode n = lists[i];
                if(n!=null&&n.val<min){
                    min=n.val;
                    index=i;
                }
            }
            if(index==-1){
                break;
            }else{
                node.next=new ListNode(min);
                node=node.next;
                ListNode list = lists[index];
                lists[index]=list.next;
            }
        }
        return pre.next;
    }
}
