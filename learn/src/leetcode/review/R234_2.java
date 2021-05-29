package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R234_2 {
// 输入: 1->2->2->1
//输出: true
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        int size = list.size();//0123 4 //01234 5
        int mid=size/2;
        for(int i=0;i<mid;i++){
            if(list.get(i).val!=list.get(size-1-i).val){
                return false;
            }
        }
        return true;
    }
}
