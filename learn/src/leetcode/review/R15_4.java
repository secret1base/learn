package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R15_4 {
    //三个元素 a，b，c ，使得 a + b + c = 0
    //		执行耗时:794 ms,击败了5.09% 的Java用户
    //		内存消耗:42.5 MB,击败了49.90% 的Java用户
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length&&nums[i]<=0; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int left = i+1; left < nums.length; left++) {
                if(left>i+1&&nums[left]==nums[left-1]){
                    continue;
                }
                int right=nums.length-1;
                while (left<right&&-nums[i]<nums[left]+nums[right]){
                    right--;
                }
                if(left==right){
                    break;
                }
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
