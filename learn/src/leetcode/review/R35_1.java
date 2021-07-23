package leetcode.review;

/**
 * 35. 搜索插入位置
 * @author: wyj
 * @date: 2021/07/23
 */
public class R35_1 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *  请必须使用时间复杂度为 O(log n) 的算法。
     *  示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *  示例 2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *  示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *  示例 4:
     * 输入: nums = [1,3,5,6], target = 0
     * 输出: 0
     *  示例 5:
     * 输入: nums = [1], target = 0
     * 输出: 0
     *  提示:
     *  1 <= nums.length <= 104
     *  -104 <= nums[i] <= 104
     *  nums 为无重复元素的升序排列数组
     *  -104 <= target <= 104
     *
     *  相比普通的二分查找，由于需要返回可以插入的位置，花了比较多时间在分析情况上
     *  		执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.8 MB,击败了83.61% 的Java用户
     */
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        return searchInsert(left,right,nums,target);
    }

    private int searchInsert(int left, int right, int[] nums, int target) {
        if(left>right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        int i=0;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            i = searchInsert(left, mid - 1, nums, target);
        }else{
            i= searchInsert(mid+1,right,nums,target);
        }
        if(i==-1){
            if(nums[left]<target&&target<nums[right]){
                return left+1;
            }else if(left==right&&nums[left]>target){
                return left;
            }else if(nums[right]<target){
                return right+1;
            }else if(nums[left]>target){
                return left;
            }
        }else{
            return i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new R35_1().searchInsert(new int[]{1,3},0));
    }
}
