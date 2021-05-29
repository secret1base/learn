package leetcode;

import java.util.*;

/**
 * 239.滑动窗口最大值
 * @author: wyj
 * @date: 2021/05/27
 */
public class A239_SlidingWindowMaximum {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     *  返回滑动窗口中的最大值。
     *  示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *  示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     *  示例 3：
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     *  示例 4：
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     *  示例 5：
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *  提示：
     *  1 <= nums.length <= 105
     *  -104 <= nums[i] <= 104
     *  1 <= k <= nums.length
     *
     * @return
     */
    public static void main(String[] args) {
        int[] ints = new A239_SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 			执行耗时:39 ms,击败了55.32% 的Java用户
     * 			内存消耗:53 MB,击败了62.46% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //一个个窗口的值
        int[] res=new int[nums.length-k+1];
        Deque<Integer> deque=new LinkedList<>();
        //right为窗口最右侧位置
        for (int right = 0; right < nums.length; right++) {
            //保持队首元素始终为最大值
            while (deque.size()>0&&nums[deque.peekLast()] < nums[right]){
                deque.removeLast();
            }
            //将当前元素进行添加
            deque.offerLast(right);
            //当前窗口最左侧位置
            int left=right-k+1;
            //计算队首元素位置，当队首不在窗口内时移除队首元素
            if(deque.peekFirst()<left){
                deque.pollFirst();
            }
            //当窗口最右侧位置等于k-1时窗口形成，-1是因为窗口是从0开始的
            if(right>=k-1){
                res[left]=nums[deque.peekFirst()];
            }
        }
        return res;
    }

//    /**
//     * 超时
//     * @param nums
//     * @param k
//     * @return
//     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        List<Integer> list=new ArrayList<>();
//        Queue<Integer> queue=new LinkedList<>();
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            max=Math.max(max,nums[i]);
//            queue.offer(nums[i]);
//            if(queue.size()==k){
//                list.add(max);
//                if(queue.poll()==max){
//                    ArrayList<Integer> tmp = new ArrayList<>(queue);
//                    max=Integer.MIN_VALUE;
//                    for (Integer a : tmp) {
//                        max=Math.max(a,max);
//                    }
//                }
//            }
//        }
//        int[] arr=new int[list.size()];
//        for (int i = 0; i < list.size(); i++){
//            arr[i]=list.get(i);
//        }
//        return arr;
//    }
}
