package leetcode.review;

import leetcode.tool.ListNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R148_2 {
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]

    /**
     * 		执行耗时:34 ms,击败了8.71% 的Java用户
     * 		内存消耗:53.4 MB,击败了5.01% 的Java用户
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode node=head;
        Map<Integer, List<ListNode>> map=new HashMap<>();
        while (node!=null){
            List<ListNode> list = map.get(node.val);
            if(list==null){
                list = new ArrayList<>();
            }
            list.add(node);
            map.put(node.val, list);
            node=node.next;
        }
        Set<Integer> set = map.keySet();
        Set<Integer> ss = new TreeSet<>(set);
        ListNode hair=new ListNode();
        node=hair;
        for (Integer s : ss) {
            List<ListNode> list = map.get(s);
            for (ListNode listNode : list) {
                listNode.next=null;
                node.next=listNode;
                node=node.next;
            }
        }
        return hair.next;
    }
}
