package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.SetListNodeUtil;

/**
 * 21. 合并两个有序链表
 * @author: wyj
 * @date: 2021/04/22
 */
public class A21_MergeTwoOrderedLinkedLists {
    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */
    public static void main(String[] args) {
        ListNode l1 = SetListNodeUtil.setListNode(new int[]{1, 2, 4});
        ListNode l2 = SetListNodeUtil.setListNode(new int[]{1,3,4});
        ListNode listNode = new A21_MergeTwoOrderedLinkedLists().mergeTwoLists(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了25.59%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了58.39%的用户
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode left=l1;
        ListNode right=l2;
        ListNode pre=new ListNode();
        ListNode next=pre;
        while (left!=null&&right!=null){
            int a = left.val;
            int b = right.val;
            if(a<b){
                next.next=new ListNode(a);
                left=left.next;
            }else{
                next.next=new ListNode(b);
                right=right.next;
            }
            next=next.next;
        }
        while (left!=null){
            next.next=new ListNode(left.val);
            next=next.next;
            left=left.next;
        }
        while (right!=null){
            next.next=new ListNode(right.val);
            next=next.next;
            right=right.next;
        }
        return pre.next;
    }
}
