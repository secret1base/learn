package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R300_3 {
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。
// 示例 1：
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public int lengthOfLIS(int[] nums) {
        int[] store=new int[nums.length];
        Arrays.fill(store, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[i],store[j]+1);
                }
            }
        }
        int max=0;
        for (int i = 0; i < store.length; i++) {
            max=Math.max(max,store[i]);
        }
        return max;
    }
}
