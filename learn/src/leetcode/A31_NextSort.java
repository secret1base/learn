package leetcode;

import java.util.Arrays;

/**
 * 31.下一个排列
 * @author: wyj
 * @date: 2021/04/28
 */
public class A31_NextSort {
    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须 原地 修改，只允许使用额外常数空间。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     * 示例 4：
     * 输入：nums = [1]
     * 输出：[1]
     * 提示：
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    public static void main(String[] args) {
//        int[] a = {1, 2, 3};
//        new A31_NextSort().nextPermutation(a);
//        System.out.println(Arrays.toString(a));//[1, 3, 2]
//        int[] b = {3,2,1};
//        new A31_NextSort().nextPermutation(b);
//        System.out.println(Arrays.toString(b));//[1, 2, 3]
        int[] c = {1,3,2};
        new A31_NextSort().nextPermutation(c);
        System.out.println(Arrays.toString(c));//[2,1,3]
    }

    /**
     * 这道题最重要的是获取下一个排列：
     * 1、找到破坏倒序排列的数 nums[i-1]<nums[i]
     * 2、从右向左找到第一个大于nums[i-1]的数nums[k]
     * 3、交换k和i-1的位置后对i开始的位置进行升序排列
     * 执行耗时:1 ms,击败了98.24% 的Java用户
     * 内存消耗:38.7 MB,击败了52.29% 的Java用户
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //记录是否进行了下一个排列，如果没有执行则进行升序排列
        boolean flag=false;
        //进行下一个排列，j应该始终保持在i的左边
        //从后向前找到nums[i-1]<nums[i]的数，举例 2431 2<4满足条件，接着在2的右边找到比2大的最小的数进行交换位置
        //然后对i-1后面的数进行升序排列，也就是从i开始升序排列
        for (int i=nums.length - 1; i > 0; i--){
            if(nums[i-1]<nums[i]){
                for (int k=nums.length - 1; k > i-1; k--){
                    //找到比nums[i-1]大的最小的值
                    if(nums[i-1]<nums[k]){
                        //交换位置
                        int tmp=nums[i-1];
                        nums[i-1]=nums[k];
                        nums[k]=tmp;
                        //记录
                        flag=true;
                        //交换后需要对j的后面进行升序排列
                        for (int a=i;a<nums.length;a++){
                            for(int b=a+1;b<nums.length;b++){
                                if(nums[a]>nums[b]){
                                    int t=nums[a];
                                    nums[a]=nums[b];
                                    nums[b]=t;
                                }
                            }
                        }
                        break;
                    }
                }

            }
            if(flag){
                break;
            }
        }
        if(!flag){
            //进行升序排列
            for (int i=0;i<nums.length; i++){
                for (int j=i+1;j<nums.length;j++){
                    if(nums[i]>nums[j]){
                        int tmp = nums[i];
                        nums[i]=nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
    }
}
