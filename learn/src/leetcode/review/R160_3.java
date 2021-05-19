package leetcode.review;

import leetcode.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/18
 */
public class R160_3 {
    //			执行耗时:25 ms,击败了5.57% 的Java用户
    //			内存消耗:45.6 MB,击败了5.03% 的Java用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<String,Integer> map=new HashMap<>();
        while (headA!=null){
            map.put(headA.toString(),1);
            headA=headA.next;
        }
        while (headB != null) {
            Integer orDefault = map.getOrDefault(headB.toString(),0);
            if(orDefault==1){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
