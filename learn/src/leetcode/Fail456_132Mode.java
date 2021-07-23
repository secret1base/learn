//package leetcode;
//
///**
// * 456. 132模式
// * @author: wyj
// * @date: 2021/07/15
// */
//public class Fail456_132Mode {
//    /**
//     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//     * ：i < j < k 和 nums[i] < nums[k] < nums[j] 。
//     *  如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
//     *  示例 1：
//     * 输入：nums = [1,2,3,4]
//     * 输出：false
//     * 解释：序列中不存在 132 模式的子序列。
//     *  示例 2：
//     * 输入：nums = [3,1,4,2]
//     * 输出：true
//     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
//     *  示例 3：
//     * 输入：nums = [-1,3,2,0]
//     * 输出：true
//     * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
//     */
//    /**
//     * 超时问题，说明需要去找规律
//     * @param nums
//     * @return
//     */
//    public boolean find132pattern(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if(i>0&&nums[i]==nums[i-1]){
//                continue;
//            }
//            for (int j = i+1; j < nums.length; j++) {
//                if(j>i+1&&nums[j]==nums[j-1]){
//                    continue;
//                }
//                for (int k = j+1; k < nums.length; k++) {
//                    if(k>j+1&&nums[k]==nums[k-1]){
//                        continue;
//                    }
//                    if(nums[i] < nums[k]&&nums[k]< nums[j]){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        boolean pattern = new Fail456_132Mode().find132pattern(new int[]{1, 2, 3, 4});
//        System.out.println(pattern);
//    }
//}
