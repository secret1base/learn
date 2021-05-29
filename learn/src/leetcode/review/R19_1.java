package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R19_1 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *  示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *  示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *  示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     */
    /**
     * 			执行耗时:1 ms,击败了19.46% 的Java用户
     * 			内存消耗:37.7 MB,击败了5.02% 的Java用户
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
        int i = list.size() - n-1;
        if(i>=0){
            ListNode pre = list.get(i);
            ListNode del = pre.next;
            ListNode after=null;
            if(del!=null){
                after=del.next;
            }
            pre.next=after;
        }
        return hair.next;
    }
}
