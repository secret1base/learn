package leetcode;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author: wyj
 * @date: 2021/07/02
 */
public class A167_SumOfTwoNumbersII_InputOrderedArray {
    /**
     * 给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *  函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *  你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *  示例 1：
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *  示例 2：
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     *  示例 3：
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     *
     * 			执行耗时:69 ms,击败了12.23% 的Java用户
     * 			内存消耗:38.5 MB,击败了74.35% 的Java用户
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>target){
                break;
            }
            for (int j = i+1; j <numbers.length;j++ ){
                int sum = numbers[i] + numbers[j];
                if(sum==target){
                    return new int[]{i+1,j+1};
                }else if(sum>target){
                    break;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new A167_SumOfTwoNumbersII_InputOrderedArray().twoSum(new int[]{2,3,4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
