//package leetcode;
//
///**
// * @author: wyj
// * @date: 2021/07/09
// */
//public class Fail525_ContinuousArray {
//    /**
//     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//     *  示例 1:
//     * 输入: nums = [0,1]
//     * 输出: 2
//     * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
//     *  示例 2:
//     * 输入: nums = [0,1,0]
//     * 输出: 2
//     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
//     */
//    /**
//     * TODO 具说需要通过前缀法进行实现
//     */
//    /**
//     * 存在超时问题
//     * @param nums
//     * @return
//     */
//    public int findMaxLength(int[] nums) {
//        //当当前所有值的和sum=size/2长度一半，即为符合要求的,
//        int max=0;
//        for (int i = 0; i < nums.length; i++) {
//            int size=0;
//            int sum=0;
//            for (int j = i; j < nums.length; j++) {
//                size++;
//                sum+=nums[j];
//                if(size%2==0&&size/2==sum){
//                    max=Math.max(size,max);
//                }
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        int maxLength = new Fail525_ContinuousArray().findMaxLength(new int[]{0, 1,0,1,0,0,1});
//        System.out.println(maxLength);
//    }
//
//}
