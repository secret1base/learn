package leetcode;

import leetcode.tool.ListNode;

/**
 * 141.环形链表
 * @author: wyj
 * @date: 2021/05/14
 */
public class A141_RingList {
    /**
     * 给定一个链表，判断链表中是否有环。
     *  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
     * 位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *  如果链表中存在环，则返回 true 。 否则，返回 false 。
     *  进阶：
     *  你能用 O(1)（即，常量）内存解决此问题吗？
     *  示例 1：
     *  输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *  示例 2：
     *  输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *  示例 3：
     *  输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *  提示：
     *  链表中节点的数目范围是 [0, 104]
     *  -105 <= Node.val <= 105
     *  pos 为 -1 或者链表中的一个 有效索引 。
     */
    public static void main(String[] args) {
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
        boolean b = new A141_RingList().hasCycle(a1);
        System.out.println(b);
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.6 MB,击败了48.10% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (true){
            if(fast==null||fast.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
    }
}
