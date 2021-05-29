package leetcode.review;

import leetcode.tool.ListNode;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R23_1 {
    /**
     * 			执行耗时:348 ms,击败了5.06% 的Java用户
     * 			内存消耗:39.9 MB,击败了86.69% 的Java用户
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode hair=new ListNode();
        ListNode node=hair;
        while (true){
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for (int i = 0; i < lists.length; i++) {
                ListNode tmp = lists[i];
                if(tmp!=null&&tmp.val<min){
                    min=tmp.val;
                    minIndex=i;
                }
            }
            if(minIndex==-1){
                return hair.next;
            }
            node.next=new ListNode(min);
            node=node.next;
            lists[minIndex]=lists[minIndex].next;
        }
    }

}
