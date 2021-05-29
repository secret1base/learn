package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        Deque<Integer> deque=new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[right]){
                deque.removeLast();
            }
            deque.offerLast(right);
            int left=right-k+1;
            if(deque.peekFirst()<left){
                deque.removeFirst();
            }
            if(right>=k-1){
                res[left]=nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
