package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R19_2 {
    /**
     *      * 输入：head = [1,2,3,4,5], n = 2
     *      * 输出：[1,2,3,5]
     * @param head
     * @param n
     * @return
     *      执行耗时:1 ms,击败了19.46% 的Java用户
     * 		内存消耗:37.8 MB,击败了5.02% 的Java用户
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list=new ArrayList<>();
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair;
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int pre=list.size()-n-1;//12345
        ListNode listNode = list.get(pre);
        ListNode del = listNode.next;
        listNode.next=del.next;
        return hair.next;
    }
}
