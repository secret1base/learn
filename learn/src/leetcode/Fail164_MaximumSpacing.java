package leetcode;

import java.util.Arrays;

/**
 * 164. 最大间距
 * @author: wyj
 * @date: 2021/07/19
 */
public class Fail164_MaximumSpacing {
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     *  如果数组元素个数小于 2，则返回 0。
     *  示例 1:
     *  输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     *  示例 2:
     *  输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     *  说明:
     *  你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     *  请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     *
     * 没考虑线性时间复杂度和空间复杂度条件，也就是说没有满足题目要求
     *  		执行耗时:46 ms,击败了26.42% 的Java用户
     * 			内存消耗:52.4 MB,击败了13.46% 的Java用户
     */
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(i+1<nums.length){
                max=Math.max(nums[i+1]-nums[i],max);
            }
        }
        return max;
    }
}
