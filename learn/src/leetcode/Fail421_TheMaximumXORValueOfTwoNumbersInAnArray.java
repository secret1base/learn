//package leetcode;
//
///**
// * 421. 数组中两个数的最大异或值
// * @author: wyj
// * @date: 2021/07/12
// */
//public class Fail421_TheMaximumXORValueOfTwoNumbersInAnArray {
//    /**
//     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
//     *  进阶：你可以在 O(n) 的时间解决这个问题吗？
//     *  示例 1：
//     * 输入：nums = [3,10,5,25,2,8]
//     * 输出：28
//     * 解释：最大运算结果是 5 XOR 25 = 28.
//     *  示例 2：
//     * 输入：nums = [0]
//     * 输出：0
//     *  示例 3：
//     * 输入：nums = [2,4]
//     * 输出：6
//     *  示例 4：
//     * 输入：nums = [8,10,2]
//     * 输出：10
//     *  示例 5：
//     * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//     * 输出：127
//     *  提示：
//     *  1 <= nums.length <= 2 * 104
//     *  0 <= nums[i] <= 231 - 1
//     *  Related Topics 位运算 字典树 数组 哈希表
//     *
//     *
//     */
//
//    public int findMaximumXOR(int[] nums) {
//        //需要找到规律 TODO
//    }
////    /**
////     * 暴力破解超时
////     * 注意点：1、异或算法是什么 2、值可以异或自己本身
////     */
////    public int findMaximumXOR(int[] nums) {
////        int max=Integer.MIN_VALUE;
////        for (int i = 0; i < nums.length; i++) {
////            for (int j = i; j < nums.length; j++) {
////                max=Math.max(max,nums[i]^nums[j]);
////            }
////        }
////        return max;
////    }
//
//    public static void main(String[] args) {
////        int maximumXOR = new A421_TheMaximumXORValueOfTwoNumbersInAnArray().findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70});
////        System.out.println(maximumXOR);
////        int maximumXOR = new A421_TheMaximumXORValueOfTwoNumbersInAnArray().findMaximumXOR(new int[]{0});
////        System.out.println(maximumXOR);
//        System.out.println(1^1);
//    }
//}
