package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R15_3 {
    //本次出错:1、未进行排序 2、在list.add后直接break了
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < nums.length&&nums[i]<=0; i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int left = i+1; left < nums.length;left++){
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
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    list.add(tmp);
                    break;
                }
            }
        }
        return list;
    }
}
