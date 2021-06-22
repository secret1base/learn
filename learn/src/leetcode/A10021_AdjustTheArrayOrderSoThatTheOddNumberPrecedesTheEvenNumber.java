package leetcode;

import java.util.Arrays;

/**
 * 剑指 Offer 21.调整数组顺序使奇数位于偶数前面
 * @author: wyj
 * @date: 2021/06/15
 */
public class A10021_AdjustTheArrayOrderSoThatTheOddNumberPrecedesTheEvenNumber {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *  示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * 		执行耗时:3 ms,击败了29.45% 的Java用户
     * 		内存消耗:47.9 MB,击败了9.98% 的Java用户
     */
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int[] arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num%2==0){
                arr[right--]=num;
            }else{
                arr[left++]=num;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] exchange = new A10021_AdjustTheArrayOrderSoThatTheOddNumberPrecedesTheEvenNumber().exchange(new int[]{1, 2, 3, 4});
        int[] exchange = new A10021_AdjustTheArrayOrderSoThatTheOddNumberPrecedesTheEvenNumber().exchange(new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1});
        System.out.println(Arrays.toString(exchange));
    }
}
