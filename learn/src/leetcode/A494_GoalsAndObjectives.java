package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 494. 目标和
 * @author: wyj
 * @date: 2021/07/09
 */
public class A494_GoalsAndObjectives {
    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *  向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *  例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     *  返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *  示例 1：
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *  示例 2：
     * 输入：nums = [1], target = 1
     * 输出：1
     */
    /**
     * 			执行耗时:589 ms,击败了37.48% 的Java用户
     * 			内存消耗:35.7 MB,击败了90.02% 的Java用户
     */
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        //暴力破解,回溯算法找到所有可能
        record(0,0,nums,target);
        return count;
    }

    private void record(int index,int sum, int[] nums, int target) {
        if(index==nums.length){
            if(sum==target){
               count++;
            }
            return;
        }
        //两种路线，分别是+和-
        record(index+1,sum+nums[index],nums,target);
        record(index+1,sum-nums[index],nums,target);
    }

    public static void main(String[] args) {
        int targetSumWays = new A494_GoalsAndObjectives().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
