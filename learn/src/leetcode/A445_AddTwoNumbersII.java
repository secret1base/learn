package leetcode;

import leetcode.tool.ListNode;

/**
 * 445. 两数相加 II
 * @author: wyj
 * @date: 2021/07/12
 */
public class A445_AddTwoNumbersII {
    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *  你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *  进阶：
     *  如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *  示例：
     *  输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */
    /**
     * 不使用反转链表的方式实现,效率比反转链表低好多
     * 			执行耗时:3 ms,击败了89.71% 的Java用户
     * 			内存消耗:38.6 MB,击败了86.11% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder left=new StringBuilder();
        while (l1!=null){
            left.append(l1.val);
            l1=l1.next;
        }
        StringBuilder right=new StringBuilder();
        while (l2!=null){
            right.append(l2.val);
            l2=l2.next;
        }
        //这样就是一道字符串相加的题目
        int a=left.length()-1;
        int b=right.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while (a>=0||b>=0||carry!=0){
            int x=a>=0?left.charAt(a)-'0':0;
            int y=b>=0?right.charAt(b)-'0':0;
            int i = x + y + carry;
            a--;
            b--;
            sb.append(i%10);
            carry=i/10;
        }
        ListNode pre=new ListNode();
        ListNode node=pre;
        for (int i=sb.length()-1;i>=0;i--){
            node.next=new ListNode(sb.charAt(i)-'0');
            node=node.next;
        }
        return pre.next;
    }
//    /**
//     * 依据题目描述的反转链表的思路实现的
//     * 			执行耗时:2 ms,击败了100.00% 的Java用户
//     * 			内存消耗:38.6 MB,击败了84.46% 的Java用户
//     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        //反转相加
//        ListNode left= reverse(l1);
//        ListNode right= reverse(l2);
//        ListNode pre=new ListNode();
//        ListNode node=pre;
//        int carry=0;
//        while (left!=null||right!=null||carry!=0){
//            int a=left!=null?left.val:0;
//            int b=right!=null?right.val:0;
//            int i = a + b + carry;
//            carry = i / 10;
//            node.next=new ListNode(i%10);
//            node=node.next;
//            if(left!=null){
//                left=left.next;
//            }
//            if(right!=null){
//                right=right.next;
//            }
//        }
//        return reverse(pre.next);
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode curr=head;
//        ListNode pre=null;
//        while (curr!=null){
//            ListNode next = curr.next;
//            curr.next=pre;
//            pre=curr;
//            curr=next;
//        }
//        return pre;
//    }
}
