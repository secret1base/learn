//package leetcode;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
///**
// * 334. 递增的三元子序列
// * @author: wyj
// * @date: 2021/07/21
// */
//public class Fail334_IncreasingTernarySubsequence {
//    /**
//     * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
//     *  如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true
//     *  ；否则，返回 false 。
//     *  示例 1：
//     * 输入：nums = [1,2,3,4,5]
//     * 输出：true
//     * 解释：任何 i < j < k 的三元组都满足题意
//     *  示例 2：
//     * 输入：nums = [5,4,3,2,1]
//     * 输出：false
//     * 解释：不存在满足题意的三元组
//     *  示例 3：
//     * 输入：nums = [2,1,5,0,4,6]
//     * 输出：true
//     * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
//     *  提示：
//     *  1 <= nums.length <= 105
//     *  -231 <= nums[i] <= 231 - 1
//     */
//    /**
//     * 回溯算法超时
//     */
//    public boolean increasingTriplet(int[] nums) {
//        //子数组中存在连续递增达到三次的子数组即为true
//        Deque<Integer> path=new LinkedList<>();
//        for (int i = 0; i < nums.length;i++){
//            path.offerLast(nums[i]);
//            if(recordAdd(i,path,nums)){
//                return true;
//            }
//            path.pollLast();
//        }
//        return false;
//    }
//
//    private boolean recordAdd(int index, Deque<Integer> path, int[] nums) {
//        if(path.size()==3){
//            return true;
//        }
//        for (int i = index+1; i < nums.length; i++) {
//            if(path.peekLast()<nums[i]){
//                path.offerLast(nums[i]);
//                if(recordAdd(i,path,nums)){
//                    return true;
//                }
//                path.pollLast();
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        boolean b = new Fail334_IncreasingTernarySubsequence().increasingTriplet(new int[]{20,100,10,12,5,13});
//        System.out.println(b);
//    }
//}
