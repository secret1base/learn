package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R31_4 {
//输入：nums = [1,2,3]
//输出：[1,3,2]

    /**
     * 			执行耗时:1 ms,击败了97.36% 的Java用户
     * 			内存消耗:38.5 MB,击败了70.13% 的Java用户
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //从后向前，找到第一个破坏降序排列的数
       for (int i = nums.length-1; i >=0; i--) {
           if(i-1>=0&&nums[i]>nums[i-1]){
               //从后向前找到比i-1大的数
               for (int j = nums.length-1; j > i-1; j--) {
                   if(nums[j]>nums[i-1]){
                       //交换位置，对i-1后的数进行升序排列
                       int tmp = nums[j];
                       nums[j]=nums[i-1];
                       nums[i-1] = tmp;
                       for(int a=i;a<nums.length;a++){
                           for (int b = a+1; b <nums.length; b++) {
                               if(nums[a]>nums[b]){
                                   int t = nums[a];
                                   nums[a]=nums[b];
                                   nums[b] = t;
                               }
                           }
                       }
                       return;
                   }
               }
           }
       }
        for(int a=0;a<nums.length;a++){
            for (int b = a+1; b <nums.length; b++) {
                if(nums[a]>nums[b]){
                    int t = nums[a];
                    nums[a]=nums[b];
                    nums[b] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {3,2,1};
        new R31_4().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
