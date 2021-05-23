package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/20
 */
public class R300_2 {
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public static void main(String[] args) {
        int i = new R300_2().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
    public int lengthOfLIS(int[] nums) {
        int[] store=new int[nums.length];
        Arrays.fill(store,1);
        int max=1;
        for (int i = 1; i < nums.length; i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[i],store[j]+1);
                    max=Math.max(store[i],max);
                }
            }
        }
        return max;
    }
}
