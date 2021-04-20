package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.SetListNodeUtil;

/**
 * 2. 两数相加
 * @author: wyj
 * @date: 2021/04/20
 */
public class A2_AddTwoNumbers {
    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 2.jpg
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    public static void main(String[] args) {
        int[] l1=new int[]{2,4,3,8};
        int[] l2=new int[]{5,6,4};
        ListNode listNode1 = SetListNodeUtil.setListNode(l1);
        ListNode listNode2 = SetListNodeUtil.setListNode(l2);
        ListNode listNode = new A2_AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了19.48%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了99.47%的用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i=0;
        ListNode pre=new ListNode();
        ListNode next=pre;
        while (l1!=null||l2!=null){
            int i1 = 0;
            i1+=i;
            if(l1!=null){
                i1+=l1.val;
            }
            if(l2!=null){
                i1+=l2.val;
            }
            i=0;
            if(i1>=10){
                i1 = i1 - 10;
                i=1;
            }
            next.next=new ListNode(i1);
            next=next.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        //防止进一后两边都没有对应节点的情况
        if(i!=0){
            next.next=new ListNode(i);
        }
        return pre.next;
    }
}
