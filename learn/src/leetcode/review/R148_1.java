package leetcode.review;

import leetcode.tool.ListNode;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R148_1 {
    //输入：head = [4,2,1,3]
    //输出：[1,2,3,4]

    /**
     * 			执行耗时:36 ms,击败了8.60% 的Java用户
     * 			内存消耗:49.1 MB,击败了5.02% 的Java用户
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        Map<Integer,List<ListNode>> map=new HashMap<>();
        while (head!=null){
            List<ListNode> listNodes = map.get(head.val);
            if(listNodes==null){
                listNodes = new ArrayList<>();
            }
            listNodes.add(head);
            map.put(head.val,listNodes);
            head=head.next;
        }
        ListNode hair=new ListNode();
        ListNode node=hair;
        TreeSet<Integer> list = new TreeSet<>(map.keySet());
        for (Integer integer : list) {
            List<ListNode> listNodes = map.get(integer);
            for(int i=0;i<listNodes.size(); i++){
                ListNode listNode = listNodes.get(i);
                listNode.next=null;
                node.next=listNode;
                node=node.next;
            }
        }
        return hair.next;
    }
}
