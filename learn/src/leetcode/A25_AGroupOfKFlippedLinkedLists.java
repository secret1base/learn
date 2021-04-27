package leetcode;

import leetcode.tool.ListNode;
import leetcode.tool.SetListNodeUtil;

/**
 * 25. K 个一组翻转链表
 * @author: wyj
 * @date: 2021/04/20
 */
public class A25_AGroupOfKFlippedLinkedLists {
    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 进阶：
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 25(1).jpg
     * 25(2).jpg
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * 示例 3：
     * 输入：head = [1,2,3,4,5], k = 1
     * 输出：[1,2,3,4,5]
     * 示例 4：
     * 输入：head = [1], k = 1
     * 输出：[1]
     * 这里是题目中没有给出的规律，但是测试的时候发现是这样的有点坑
     * 输入：head = [1,2,3,4], k = 4
     * 输出：[4,3,2,1]
     * 输入：head = [1,2,3,4,5], k = 5
     * 输出：[5,4,3,2,1]
     * 提示：
     * 列表中节点的数量在范围 sz 内
     * 1 <= sz <= 5000
     * 0 <= Node.val <= 1000
     * 1 <= k <= sz
     */
    public static void main(String[] args) {
        ListNode head = SetListNodeUtil.setListNode(new int[]{1, 2,3,4,5});
        ListNode listNode = new A25_AGroupOfKFlippedLinkedLists().reverseKGroup(head, 4);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    /**
     * 25.png
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了60.50% 的Java用户
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode();
        hair.next=head;
        ListNode pre=hair;
        ListNode end=hair;
        while (end!=null){
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start=pre.next;
            ListNode next = end.next;
            end.next=null;
            //pre接收头节点
            pre.next= reverse(start);
            //start作为尾部节点连接next
            start.next=next;
            //初始化,start作为尾部节点，作为下一次循环的pre节点
            pre=start;
            end=start;
        }
        return hair.next;
    }

    /**
     * 反转节点
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode pre=null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }


}
