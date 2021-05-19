package leetcode.review;

import leetcode.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R160_2 {
    /**
     * 			执行耗时:25 ms,击败了5.53% 的Java用户
     * 			内存消耗:45.7 MB,击败了5.02% 的Java用户
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
