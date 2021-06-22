package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 384. 打乱数组
 * @author: wyj
 * @date: 2021/06/22
 */
public class A384_ScramblingArrays {
    /**
     * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
     *  实现 Solution class:
     *  Solution(int[] nums) 使用整数数组 nums 初始化对象
     *  int[] reset() 重设数组到它的初始状态并返回
     *  int[] shuffle() 返回数组随机打乱后的结果
     *  示例：
     * 输入
     * ["Solution", "shuffle", "reset", "shuffle"]
     * [[[1, 2, 3]], [], [], []]
     * 输出
     * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
     * 解释
     * Solution solution = new Solution([1, 2, 3]);
     * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
     * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
     * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
     */
    /**
     * 			执行耗时:101 ms,击败了50.27% 的Java用户
     * 			内存消耗:46.8 MB,击败了35.30% 的Java用户
     */
    int[] init=null;
    int[] arr=null;
    public A384_ScramblingArrays(int[] nums) {
        init=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            init[i]=nums[i];
        }
        arr=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int a = rand.nextInt(arr.length);
            int tmp=arr[a];
            arr[a]=arr[i];
            arr[i]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        A384_ScramblingArrays a384_scramblingArrays = new A384_ScramblingArrays(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(a384_scramblingArrays.shuffle()));
    }
}
