package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 560. 和为K的子数组
 * @author: wyj
 * @date: 2021/06/23
 */
public class A560_AndAreSubarraysOfK {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *  示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *  说明 :
     *  数组的长度为 [1, 20,000]。
     *  数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     *
     *  这道题由于是存在负数的，并且数值无规律，通过双向队列解题的计划失败
     *  		执行耗时:1428 ms,击败了26.35% 的Java用户
     * 			内存消耗:41.6 MB,击败了19.20% 的Java用户
     */
    public int subarraySum(int[] nums, int k) {
        //遍历出所有的组合
        int count=0;
        for (int i = 0; i < nums.length; i++){
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int sum = new A560_AndAreSubarraysOfK().subarraySum(new int[]{-1,-1,1}, 0);
        System.out.println(sum);
    }
}
