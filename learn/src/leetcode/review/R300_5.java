package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R300_5 {
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//			执行耗时:80 ms,击败了24.51% 的Java用户
//			内存消耗:38.1 MB,击败了45.61% 的Java用户
    public int lengthOfLIS(int[] nums) {
        int[] store=new int[nums.length];
        Arrays.fill(store,1);
        int max=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[j]+1,store[i]);
                    max=Math.max(store[i],max);
                }
            }
        }
        return max;
    }
}
