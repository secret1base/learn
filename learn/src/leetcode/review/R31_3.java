package leetcode.review;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R31_3 {
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//			执行耗时:1 ms,击败了97.59% 的Java用户
//			内存消耗:38.8 MB,击败了21.19% 的Java用户
    public void nextPermutation(int[] nums) {
        //从后向前找到破坏降序排列的值，找到后面中比该值大一点的值交换位置后，对该值后面进行升序排列
        for (int i = nums.length-1; i >=0; i--) {
            if(i-1>=0&&nums[i]>nums[i-1]){
                for (int j = nums.length - 1; j >=i; j--) {
                    if(nums[j] > nums[i-1]){
                        int tmp=nums[i-1];
                        nums[i-1]=nums[j];
                        nums[j] = tmp;
                        for(int a=i;a<nums.length;a++){
                            for (int b = a+1; b < nums.length; b++) {
                                if(nums[a]>nums[b]){
                                    int t=nums[a];
                                    nums[a]=nums[b];
                                    nums[b]=t;
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
        for(int a=0;a<nums.length;a++){
            for (int b = a+1; b < nums.length; b++) {
                if(nums[a]>nums[b]){
                    int t=nums[a];
                    nums[a]=nums[b];
                    nums[b]=t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 5};
        new R31_3().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
