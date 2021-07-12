package leetcode;

import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II
 * @author: wyj
 * @date: 2021/07/12
 */
public class A80_DeleteDuplicateItemsInSortedArrayII {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     *  不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *  说明：
     *  为什么返回数值是整数，但输出的答案是数组呢？
     *  请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *  你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *  示例 1：
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     *  示例 2：
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
     * 元素。
     *
     * 两次过，题目做的时候，有点乱，但也是简单题
     * 执行耗时:1 ms,击败了64.33% 的Java用户
     * 内存消耗:38.7 MB,击败了32.37% 的Java用户
     */
    public int removeDuplicates(int[] nums) {
        //注意:每个元素最多出现两次
        //前一个值的索引,初始为1，代表从前一个值的索引为1
        int pre=1;
        //索引从1开始
        for (int i = 2; i < nums.length; i++) {
            //如果当前值和前一个值相等,且和前前一个值相等(每个元素最多出现两次)，删除当前值
            if(nums[i]==nums[pre]&&nums[i]==nums[pre-1]){
                //说是删除，其实不做任何处理
            }else if(i-pre>1){
                //不相等，并且两者的位置差大于1则替换pre后面的值为num[i]
                nums[++pre]=nums[i];
            }else{
                pre++;
            }
        }
        return pre+1;
    }

    public static void main(String[] args) {
//        int[] ints = {1, 1, 1, 2, 2, 3};
//        int i = new A80_DeleteDuplicateItemsInSortedArrayII().removeDuplicates(ints);
//        System.out.println(i);
//        System.out.println(Arrays.toString(ints));
        int[] ints = {1, 2, 2};
        int i = new A80_DeleteDuplicateItemsInSortedArrayII().removeDuplicates(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}
