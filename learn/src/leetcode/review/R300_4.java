package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R300_4 {
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public int lengthOfLIS(int[] nums) {
        int[] store=new int[nums.length];
        Arrays.fill(store,1);
        int max=1;
        for (int i = 1; i < nums.length;i++){
            for (int j = 0; j < i;j++){
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[i],store[j]+1);
                    max= Math.max(max,store[i]);
                }
            }
        }
        return max;
    }
}
