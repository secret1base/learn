package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R148_3 {
    //		执行耗时:15 ms,击败了15.91% 的Java用户
    //		内存消耗:47.8 MB,击败了7.85% 的Java用户
    public ListNode sortList(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val,o2.val);
            }
        });
        ListNode hair=new ListNode();
        ListNode node=hair;
        for (ListNode listNode : list) {
            listNode.next=null;
            node.next=listNode;
            node=node.next;
        }
        return hair.next;
    }

}
