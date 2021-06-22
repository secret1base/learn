package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R19_5 {
    //输入：head = [1,2], n = 1
    //输出：[1]

    /**
     * 			执行耗时:1 ms,击败了19.75% 的Java用户
     * 			内存消耗:37.6 MB,击败了5.09% 的Java用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        List<ListNode> list=new ArrayList<>();
        while (node!=null){
           list.add(node);
           node=node.next;
        }
        ListNode pre=list.get(list.size()-n-1);
        ListNode del = pre.next;
        ListNode after = null;
        if(del!=null){
            after=del.next;
        }
        pre.next=after;
        return hair.next;
    }
}
