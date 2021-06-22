package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 209. 长度最小的子数组
 * @author: wyj
 * @date: 2021/06/21
 */
public class A209_TheSmallestSubarray {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *  找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
     * 度。如果不存在符合条件的子数组，返回 0 。
     *  示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *  示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     *  示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * 注：这道题里的连续数组没有特殊含义，一开始以为必须是543这样的，结果并不是只是单纯的连续
     * 解题思路：暴力破解、双向队列
     *
     * 题目本身简单，读题读错了导致多进行了思考：
     * 			执行耗时:6 ms,击败了19.86% 的Java用户
     * 			内存消耗:39.1 MB,击败了5.00% 的Java用户
     */
    public int minSubArrayLen(int target, int[] nums) {
        //存放连续数组
        Deque<Integer> path=new LinkedList<>();
        //记录最小长度
        int min=nums.length+1;
        //记录当前合是否达到要求
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            path.offerLast(num);
            sum+=num;
            while (sum>=target){
                min=Math.min(min,path.size());
                sum-= path.pollFirst();
            }
        }
        return min==nums.length+1?0:min;
    }


    public static void main(String[] args) {
        int i = new A209_TheSmallestSubarray().minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8});
        System.out.println(i);
    }
}
