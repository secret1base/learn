package leetcode;

import leetcode.tool.ListNode;

/**
 * 142. 环形链表 II
 * @author: wyj
 * @date: 2021/05/14
 */
public class A142_RingListII {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * 说明：不允许修改给定的链表。
     * 进阶：
     * 你是否可以使用 O(1) 空间解决此题？
     * 示例 1：
     * 142(1).png
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * 142(2).png
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * 142(3).png
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     * 提示：
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     */
    /**
     * 题目要求是返回链表中环的开始位置
     * @param head
     * @return
     */
    public static void main(String[] args) {
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(-4);
//        a.next=b;
//        b.next=c;
//        c.next=d;
//        d.next=b;
//        ListNode a=new ListNode(1);
//        ListNode b=new ListNode(2);
//        a.next=b;
//        b.next=a;
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        ListNode a6=new ListNode(6);
        ListNode a7=new ListNode(7);
        ListNode a8=new ListNode(8);
        ListNode a9=new ListNode(9);
        ListNode a10=new ListNode(10);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a6;
        a6.next=a7;
        a7.next=a8;
        a8.next=a9;
        a9.next=a10;
        a10.next=a6;
        ListNode listNode = new A142_RingListII().detectCycle(a1);
        System.out.println(listNode.val);
    }

    /**
     * 通过快慢指针的找到环的入口，原理是当快指针和慢指针相等时，为index赋值头节点，
     * 下次循环时index也开始按慢指针的速度向后移动
     * 当慢指针与index重合，则该节点为环入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode index=null;
        while (true){
            if(fast==null||fast.next ==null){
                return null;
            }
            slow = slow.next;
            fast=fast.next.next;
            if(slow.equals(fast)){
                index=head;
                break;
            }
        }
        while (index!=slow){
            index=index.next;
            slow=slow.next;
        }
        return index;
    }
}
