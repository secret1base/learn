//package leetcode;
//
///**
// * 523. 连续的子数组和
// * @author: wyj
// * @date: 2021/07/21
// */
//public class Fail523_ContinuousSubarraysSum {
//    /**
//     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//     *  子数组大小 至少为 2 ，且
//     *  子数组元素总和为 k 的倍数。
//     *  如果存在，返回 true ；否则，返回 false 。
//     *  如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
//     *  示例 1：
//     * 输入：nums = [23,2,4,6,7], k = 6
//     * 输出：true
//     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
//     *  示例 2：
//     * 输入：nums = [23,2,6,4,7], k = 6
//     * 输出：true
//     * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
//     * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
//     *  示例 3：
//     * 输入：nums = [23,2,6,4,7], k = 13
//     * 输出：false
//     *  提示：
//     *  1 <= nums.length <= 105
//     *  0 <= nums[i] <= 109
//     *  0 <= sum(nums[i]) <= 231 - 1
//     *  1 <= k <= 231 - 1
//     *
//     */
//    /**
//     * 回溯算法超时
//     * @param nums
//     * @param k
//     * @return
//     */
//    public boolean checkSubarraySum(int[] nums, int k) {
//        //1、子数组大小 至少为 2 ，且
//        //2、子数组元素总和为 k 的倍数。
//        //3、必须连续 之前解题的时候没有留意到
//        boolean[] used=new boolean[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            used[i]=true;
//            if(getAdd(1,i,nums,k,used,nums[i])){
//                return true;
//            }
//            used[i]=false;
//        }
//        return false;
//    }
//
//    private boolean getAdd(int count, int index, int[] nums, int k, boolean[] used, int sum) {
//        if(count>1&&sum%k==0){
//            System.out.println(sum);
//            return true;
//        }
//        int i = index+1;
//        if(i<nums.length&&!used[i]){
//            used[i]=true;
//            if(getAdd(count+1,i,nums,k,used,sum+nums[i])){
//                return true;
//            }
//            used[i]=false;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Fail523_ContinuousSubarraysSum().checkSubarraySum(new int[]{23,2,6,4,7},6));
//        System.out.println(new Fail523_ContinuousSubarraysSum().checkSubarraySum(new int[]{23,2,6,4,7},13));
//        System.out.println(new Fail523_ContinuousSubarraysSum().checkSubarraySum(new int[]{23,2,4,6,6},7));
//    }
//}
