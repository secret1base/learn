package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.SetListNodeUtil;

/**
 * 23. 合并K个升序链表
 * @author: wyj
 * @date: 2021/04/22
 */
public class A23_MergeKAscendingLinkedLists {
    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    public static void main(String[] args) {
        ListNode[] listNodes=new ListNode[3];
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode a = SetListNodeUtil.setListNode(new int[]{1, 4, 5});
        ListNode b = SetListNodeUtil.setListNode(new int[]{1, 3, 4});
        ListNode c = SetListNodeUtil.setListNode(new int[]{2, 6});
        listNodes[0]=a;
        listNodes[1]=b;
        listNodes[2]=c;
        ListNode listNode = new A23_MergeKAscendingLinkedLists().mergeKLists(listNodes);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 执行用时：307 ms, 在所有 Java 提交中击败了8.19%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了71.40%的用户
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre=new ListNode();
        ListNode next=pre;
        ListNode small=null;
        //每次取数组中最小的节点，将值放入新节点中，然后将数组中对应索引位置的节点替换为被当前节点的下一个节点
        while ((small=getSmallest(lists))!=null){
            next.next=new ListNode(small.val);
            next=next.next;
        }
        return pre.next;
    }

    private ListNode getSmallest(ListNode[] lists) {
        int min=Integer.MAX_VALUE;
        int smallIndex=-1;
        for (int i=0;i<lists.length;i++){
            ListNode node = lists[i];
            if(node==null){
                continue;
            }
            if(node.val<min){
                smallIndex=i;
                min=node.val;
            }
        }
        //找到最小节点，将最小节点的后一位替换为数组中的元素,返回当前的最小节点
        if(smallIndex==-1){
            return null;
        }
        ListNode smallNode = lists[smallIndex];
        lists[smallIndex]=smallNode.next;
        return smallNode;
    }
}
