package leetcode;

import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 * @author: wyj
 * @date: 2021/07/12
 */
public class A503_NextLargerElementII {
    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
     * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *  示例 1:
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * 一次过
     * 			执行耗时:58 ms,击败了7.43% 的Java用户
     * 			内存消耗:39.5 MB,击败了91.58% 的Java用户
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] store=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            searchNextMax(i,nums,store);
        }
        return store;
    }

    private void searchNextMax(int begin, int[] nums, int[] store) {
        for (int i = 1; i < nums.length; i++) {
            int cur=begin+i;
            if(cur>=nums.length){
                cur-=nums.length;
            }
            if(nums[begin]<nums[cur]){
                store[begin]=nums[cur];
                return;
            }
        }
        store[begin]=-1;
    }

    public static void main(String[] args) {
        int[] ints = new A503_NextLargerElementII().nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }
}
