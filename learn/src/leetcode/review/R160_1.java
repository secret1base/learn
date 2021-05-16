package leetcode.review;
//编写一个程序，找到两个单链表相交的起始节点。

import leetcode.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R160_1 {
    /**
     * 执行耗时:25 ms,击败了5.57% 的Java用户 内存消耗:44.8 MB,击败了5.03% 的Java用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<String,Integer> map=new HashMap<>();
        while (headA!=null){
            map.put(headA.toString(),1);
            headA=headA.next;
        }
        while (headB != null) {
            Integer orDefault = map.getOrDefault(headB.toString(), 0);
            if(orDefault==1){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
