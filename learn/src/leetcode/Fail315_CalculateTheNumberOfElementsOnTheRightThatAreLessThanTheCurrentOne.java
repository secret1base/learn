//package leetcode;
//
//import java.util.List;
//
///**
// * 315. 计算右侧小于当前元素的个数
// * @author: wyj
// * @date: 2021/07/12
// */
//public class Fail315_CalculateTheNumberOfElementsOnTheRightThatAreLessThanTheCurrentOne {
//    /**
//     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//     * s[i] 的元素的数量。
//     *  示例：
//     *  输入：nums = [5,2,6,1]
//     * 输出：[2,1,1,0]
//     * 解释：
//     * 5 的右侧有 2 个更小的元素 (2 和 1)
//     * 2 的右侧仅有 1 个更小的元素 (1)
//     * 6 的右侧有 1 个更小的元素 (1)
//     * 1 的右侧有 0 个更小的元素
//     *
//     *
//     */
//    public List<Integer> countSmaller(int[] nums) {
//
//        return list;
//    }
////    /**
////     * 暴力破解，超时,动态规划没思路
////     */
////    public List<Integer> countSmaller(int[] nums) {
////        //从右向左遍历，每次找到比当前值小的数量+1，取最大值
////        int[] store=new int[nums.length];
////        for (int i = nums.length-1; i >=0; i--){
////            for (int j = i+1; j < nums.length; j++) {
////                if(nums[j]<nums[i]){
////                    store[i]=store[i]+1;
////                }
////            }
////        }
////        List<Integer> list=new ArrayList<>();
////        for (int i : store) {
////            list.add(i);
////        }
////        return list;
////    }
//
//    public static void main(String[] args) {
//        System.out.println(new Fail315_CalculateTheNumberOfElementsOnTheRightThatAreLessThanTheCurrentOne().countSmaller(new int[]{5, 2, 6, 1}));
//        System.out.println(new Fail315_CalculateTheNumberOfElementsOnTheRightThatAreLessThanTheCurrentOne().countSmaller(new int[]{2,0,1}));
//    }
//}
