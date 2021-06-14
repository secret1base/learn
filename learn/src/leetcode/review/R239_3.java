package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R239_3 {
    //			执行耗时:41 ms,击败了45.26% 的Java用户
    //			内存消耗:53 MB,击败了63.95% 的Java用户
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr=new int[nums.length-k+1];
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            int left=i-k+1;
            if(left>deque.peekFirst()){
                deque.pollFirst();
            }
            if(left>=0){
                arr[left]=nums[deque.peekFirst()];
            }
        }
        return arr;
    }


}
