package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 61.旋转链表
 * @author: wyj
 * @date: 2021/06/23
 */
public class A61_RotatingLinkedList {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *  示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     *  示例 2：
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     *
     * 解题思路：
     * 闭合为环后移动指针，确定头节点后将尾节点断开，向后移动次数并不等于k，需要进行计算total-k%total次
     * 			执行耗时:1 ms,击败了52.05% 的Java用户
     * 			内存消耗:37.8 MB,击败了65.34% 的Java用户
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        //闭合为环后移动指针，确定头节点后将尾节点断开，向后移动次数并不等于k，需要进行计算total-k%total次
        ListNode node=head;
        //因为题目中要求的移动方式不是指针向后移动，而是指针向前移动因此只能通过计算节点总数后：向后移动次数=总数-k的绝对值次
        int count=0;
        while (node!=null){
            count++;
            ListNode next = node.next;
            if(next==null){
                node.next=head;
                break;
            }else{
                node=node.next;
            }
        }
        ListNode point=head;
        //把向后移动改为向前移动的核心的计算公式
        int moveCount = count - k % count;
        for(int i = 0; i < moveCount; i++){
            //移动指针
            point=point.next;
        }
        //断开尾节点
        ListNode after=point;
        while (after!=null){
            ListNode next = after.next;
            if(next==point){
                after.next=null;
                break;
            }else{
                after=after.next;
            }
        }
        return point;
    }
//    /**
//     * 被判定为超时了，看测试用例是全部通过了,应该是不在预期时间内强制判断超时了
//     * @param head
//     * @param k
//     * @return
//     */
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head==null){
//            return null;
//        }
//        List<ListNode> list=new ArrayList<>();
//        ListNode node=head;
//        while (node!=null){
//            list.add(node);
//            node=node.next;
//        }
//        while (k-list.size()>0){
//            k=k-list.size();
//        }
//        List<ListNode> listNodes=new ArrayList<>();
//        for (int i=list.size()-k;i<list.size();i++){
//            listNodes.add(list.get(i));
//        }
//        for(int i=0;i<list.size()-k;i++){
//            listNodes.add(list.get(i));
//        }
//        for (int i = 1; i < listNodes.size(); i++) {
//            ListNode pre = listNodes.get(i - 1);
//            ListNode curr = listNodes.get(i);
//            pre.next=curr;
//            curr.next=null;
//        }
//        return listNodes.get(0);
//    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        ListNode listNode = new A61_RotatingLinkedList().rotateRight(a1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
