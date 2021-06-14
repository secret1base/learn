package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R19_4 {
    //			执行耗时:1 ms,击败了19.53% 的Java用户
    //			内存消耗:37.6 MB,击败了5.00% 的Java用户
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair=new ListNode();
        hair.next=head;
        List<ListNode> list=new ArrayList<>();
        ListNode node=hair;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        ListNode pre = list.get(list.size() - n - 1);
        ListNode del = pre.next;
        ListNode after = null;
        if(del!=null){
            after=del.next;
        }
        pre.next=after;
        return hair.next;
    }

}
