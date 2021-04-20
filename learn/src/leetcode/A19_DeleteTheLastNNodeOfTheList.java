package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author: wyj
 * @date: 2021/04/19
 */
public class A19_DeleteTheLastNNodeOfTheList {
    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 19.jpg
     * 进阶：你能尝试使用一趟扫描实现吗？
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public static void main(String[] args) {
        ListNode first=new ListNode(1);
        ListNode node=first;
        for (int a=2;a<3;a++) {
            ListNode listNode = new ListNode(a);
            node.next=listNode;
            node=listNode;
        }
        ListNode listNode = new A19_DeleteTheLastNNodeOfTheList().removeNthFromEnd(first, 2);
        System.out.println(listNode);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了18.90%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了5.11%的用户
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        //遍历所有节点
        List<ListNode> list=new ArrayList<>();
        list.add(head);
        while (p.next!=null){
            list.add(p.next);
            p=p.next;
        }
        //0 1 2 3 倒数第二个=> 4-2=2 =>需要找到目标节点的上一个节点 4-2-1=1
        int i = list.size() - n-1;
        if(i<0){
            //如果小于零则删除头节点
            head=head.next;
            return head;
        }
        ListNode pre = list.get(i);
        //删除节点
        pre.next=pre.next.next;
        return head;
    }
}
