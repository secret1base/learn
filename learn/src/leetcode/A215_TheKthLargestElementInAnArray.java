package leetcode;

import java.util.Arrays;

/**
 * 215.数组中第k个最大的元素
 * @author: wyj
 * @date: 2021/05/14
 */
public class A215_TheKthLargestElementInAnArray {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *  示例 1:
     *  输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *  示例 2:
     *  输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */
    public static void main(String[] args) {
        int kthLargest = new A215_TheKthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    /**
     * 升序排序后长度-k就是最大元素
     * 执行耗时:2 ms,击败了91.26% 的Java用户
     * 内存消耗:38.4 MB,击败了94.47% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
}
