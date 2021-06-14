package leetcode.review;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R239_2 {
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
    //			执行耗时:41 ms,击败了45.23% 的Java用户
//			内存消耗:52.3 MB,击败了75.65% 的Java用户
    public int[] maxSlidingWindow(int[] nums, int k) {
        //窗口数组
        int[] arr=new int[nums.length-k+1];
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!path.isEmpty()&&nums[path.peekLast()]<nums[i]){
                path.pollLast();
            }
            path.offerLast(i);
            //判断是否超出边界进行移除
            int left=i-k+1;
            if(left>path.peekFirst()){
                path.pollFirst();
            }
            if(left>=0){
                arr[left]=nums[path.peekFirst()];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new R239_2().maxSlidingWindow(new int[]{1,-1}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
