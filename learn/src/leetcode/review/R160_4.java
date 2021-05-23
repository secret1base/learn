package leetcode.review;

import leetcode.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R160_4 {
    //编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<String,Integer> map = new HashMap<>();
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
