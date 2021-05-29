package leetcode;

import leetcode.tool.ListNode;

import java.util.*;

/**
 * 148.排序链表
 * @author: wyj
 * @date: 2021/05/26
 */
public class A148_SortLinkedList {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *  进阶：
     *  你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *  示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     *  示例 2：
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     *  示例 3：
     * 输入：head = []
     * 输出：[]
     */
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(-3);
        ListNode a5 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode listNode = new A148_SortLinkedList().sortList(a1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 		执行耗时:33 ms,击败了8.73% 的Java用户
     * 		内存消耗:48.8 MB,击败了5.02% 的Java用户
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        Map<Integer,List<ListNode>> map=new HashMap<>();
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode node=hair.next;
        List<Integer> sortList=new ArrayList<>();
        while (node!=null){
            sortList.add(node.val);
            List<ListNode> listNodes = map.get(node.val);
            if(listNodes == null){
                listNodes=new ArrayList<> ();
            }
            listNodes.add(node);
            map.put(node.val,listNodes);
            node=node.next;
        }
        Collections.sort(sortList);
        node=hair;
        for (int a=0;a<sortList.size();a++) {
            if(a>0&&sortList.get(a-1).equals(sortList.get(a))){
                node=node.next;
                continue;
            }
            Integer integer = sortList.get(a);
            List<ListNode> list = map.get(integer);
            ListNode listNode = list.get(0);
            ListNode p=listNode;
            for (int i=1;i<list.size();i++){
                p.next=list.get(i);
                p=p.next;
            }
            p.next=null;
            node.next=listNode;
            node=node.next;
        }
        return hair.next;
    }
}
