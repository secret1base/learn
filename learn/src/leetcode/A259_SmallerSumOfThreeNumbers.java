package leetcode;

import java.util.Arrays;

/**
 * 259.较小的三数之和
 * @author: wyj
 * @date: 2021/04/19
 */
public class A259_SmallerSumOfThreeNumbers {
    /**
     * 259. 较小的三数之和
     * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
     * 示例：
     * 输入: nums = [-2,0,1,3], target = 2
     * 输出: 2
     * 解释: 因为一共有两个三元组满足累加和小于 2:
     *      [-2,0,1]
     *      [-2,0,3]
     * 进阶：是否能在 O(n2) 的时间复杂度内解决？
     *
     */
    public static void main(String[] args) {
//        int i = threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        int i = threeSumSmaller(new int[]{2,0,0,2,-2}, 2);
        System.out.println(i);
    }

    /**
     * 1、与最接近的三数之和类似
     * 2、先对数组进行排序
     * 3、取到初始值a后，再取两个指针left和right，right也是从左向右走right=left+1
     * 4、注意只要满足条件就count++，因此不需要进行过滤(三数之和和最接近的三数之和都需要考虑到不对重复值进行判断，在这里不需要，只要满足就加一)
     *
     * 执行用时：20 ms, 在所有 Java 提交中击败了15.17%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了44.83%的用户
     */
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int a;
        int left;
        int right;
        int count=0;
        for (a=0;a<length;a++){
            for(left=a+1;left < length; left++){
                right=left+1;
                while (right<length&&nums[left]+nums[right]+nums[a]<target) {
                    count++;
                    right++;
                }
            }
        }
        return count;
    }
}
