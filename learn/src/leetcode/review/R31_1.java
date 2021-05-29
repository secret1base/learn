package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R31_1 {
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 必须 原地 修改，只允许使用额外常数空间。
// 示例 1：
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 示例 2：
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 示例 3：
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 示例 4：
//输入：nums = [1]
//输出：[1]
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        new R31_1().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 			执行耗时:1 ms,击败了97.64% 的Java用户
     * 			内存消耗:38.6 MB,击败了61.60% 的Java用户
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >0; i--) {
            if(nums[i]>nums[i-1]){
                for (int j = nums.length-1; j > i-1; j--) {
                    if(nums[j]>nums[i-1]){
                        int tmp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=tmp;
                        for (int a=i;a<nums.length; a++){
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
        for (int a=0;a<nums.length; a++){
            for (int b = a+1; b < nums.length; b++) {
                if(nums[a]>nums[b]){
                    int t=nums[a];
                    nums[a]=nums[b];
                    nums[b]=t;
                }
            }
        }
    }
}
