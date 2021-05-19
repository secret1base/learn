package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R300_1 {
    public int lengthOfLIS(int[] nums) {
        int[] store=new int[nums.length];
        Arrays.fill(store, 1);
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[i],store[j]+1);
                }
            }
        }
        int max=0;
        for (int i = 0; i < store.length; i++) {
            max=Math.max(store[i],max);
        }
        return max;
    }
}
