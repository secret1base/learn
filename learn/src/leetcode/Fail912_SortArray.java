//package leetcode;
//
//import java.util.Arrays;
//
///**
// * 912. 排序数组
// * @author: wyj
// * @date: 2021/07/21
// */
//public class Fail912_SortArray {
//    //交换排序超时
//    public int[] sortArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[i]>nums[j]){
//                    int num = nums[i];
//                    nums[i]=nums[j];
//                    nums[j] = num;
//                }
//            }
//        }
//        return nums;
//    }
//
//    public static void main(String[] args) {
//        int[] ints = {5, 2, 3, 1};
//        new Fail912_SortArray().sortArray(ints);
//        System.out.println(Arrays.toString(ints));
//    }
//}
