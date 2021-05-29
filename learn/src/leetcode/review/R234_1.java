package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R234_1 {
    //请判断一个链表是否为回文链表。
// 示例 1:
// 输入: 1->2
//输出: false
// 示例 2:
// 输入: 1->2->2->1
//输出: true

    /**
     * 			执行耗时:8 ms,击败了43.00% 的Java用户
     * 			内存消耗:50.7 MB,击败了32.36% 的Java用户
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        int left=0;
        int right=list.size()-1;
        while (left<=right){
            if(list.get(left).val!=list.get(right).val){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
