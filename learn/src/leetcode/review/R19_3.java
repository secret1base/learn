package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R19_3 {
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]

    /**
     * 			执行耗时:1 ms,击败了19.42% 的Java用户
     * 			内存消耗:37.6 MB,击败了5.02% 的Java用户
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode hair=new ListNode();
        hair.next=head;
        while (hair!=null){
            list.add(hair);
            hair=hair.next;
        }
        int pre = list.size() - n - 1;
        ListNode preNode = list.get(pre);
        preNode.next=preNode.next.next;
        return list.get(0).next;
    }
}
