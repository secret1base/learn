package leetcode.review;

import leetcode.tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R234_3 {
    //			执行耗时:8 ms,击败了47.01% 的Java用户
    //			内存消耗:50.9 MB,击败了30.00% 的Java用户
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head != null){
            list.add(head);
            head=head.next;
        }
        int size = list.size();//0 1 2 3
        int mid=size/2;
        for(int i=0;i<mid;i++){
            if(list.get(i).val!=list.get(size-i-1).val){
                return false;
            }
        }
        return true;
    }
}
