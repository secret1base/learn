//package leetcode;
//
//import java.util.Arrays;
//
///**
// * 673. 最长递增子序列的个数
// * @author: wyj
// * @date: 2021/07/22
// */
//public class Fail673_TheNumberOfLongestIncreasingSubsequences {
//    /**
//     * 给定一个未排序的整数数组，找到最长递增子序列的个数。
//     *  示例 1:
//     * 输入: [1,3,5,4,7]
//     * 输出: 2
//     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//     *  示例 2:
//     * 输入: [2,2,2,2,2]
//     * 输出: 5
//     * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//     */
//    public int findNumberOfLIS(int[] nums) {
//        int[] store=new int[nums.length];
//        Arrays.fill(store,1);
//        int count=nums.length;
//        int max=1;
//        for (int i = 1; i < nums.length; i++){
//            for (int j = 0; j < i; j++) {
//                if(nums[j]<nums[i]){
//                    if(store[i]==store[j]+1){
//                        if(store[i]==max){
//                            count++;
//                        }else if(store[i]>max){
//                            max=store[i];
//                            count=1;
//                        }
//                    }else if(store[i]<store[j]+1){
//                        store[i]=store[j]+1;
//                        if(store[i]==max){
//                            count++;
//                        }else if(store[i]>max){
//                            max=store[i];
//                            count=1;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int numberOfLIS = new Fail673_TheNumberOfLongestIncreasingSubsequences().findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
//        System.out.println(numberOfLIS);
//    }
//}
