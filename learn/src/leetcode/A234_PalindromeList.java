package leetcode;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234.回文链表
 * @author: wyj
 * @date: 2021/05/25
 */
public class A234_PalindromeList {
    public static void main(String[] args) {
//        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(2);
//        ListNode a5 = new ListNode(1);
//        a1.next=a2;
//        a2.next=a3;
//        a3.next=a4;
//        a4.next=a5;
//        boolean palindrome = new A234_PalindromeList().isPalindrome(a1);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
//        ListNode a5 = new ListNode(1);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
//        a4.next=a5;
        boolean palindrome = new A234_PalindromeList().isPalindrome(a1);
        System.out.println(palindrome);
    }

    /**
     * 			执行耗时:8 ms,击败了42.82% 的Java用户
     * 			内存消耗:50.7 MB,击败了33.99% 的Java用户
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        int size = list.size();
        int mid = size/2;
        //5 2 0 1 2 3 4
        //4 2 0 1 2 3
        for (int left=0;left<mid;left++){
            if(list.get(left).val!=list.get(size-left-1).val){
                return false;
            }
        }
        return true;
    }
}
