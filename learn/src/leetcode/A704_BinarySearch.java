package leetcode;

/**
 * 704.二分查找
 * @author: wyj
 * @date: 2021/05/16
 */
public class A704_BinarySearch {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
     * 则返回 -1。
     * 示例 1:
     *  输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *  示例 2:
     *  输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  提示：
     *  你可以假设 nums 中的所有元素是不重复的。
     *  n 将在 [1, 10000]之间。
     *  nums 的每个元素都将在 [-9999, 9999]之间。
     */
    public static void main(String[] args) {
        int search = new A704_BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 3);
        System.out.println(search);
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.2 MB,击败了86.86% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int right = nums.length-1;
        int left=0;
        int mid=(right+left)/2;
        return doSearch(left,mid,right,target,nums);
    }

    private int doSearch(int left, int mid, int right, int target, int[] nums) {
        //小于最小，大于最大都是不存在
        if(nums[left]>target||nums[right]<target){
            return -1;
        }
        if(nums[mid] == target){//找到目标值
            return mid;
        }else if(nums[mid]>target) {//中位数大于目标值，在左边，右边界为mid-1
            right = mid - 1;
            mid = (left + right) / 2;//更新mid
        }else {//中位数小于目标值，在右边，左边界为mid+1
            left=mid+1;
            mid=(left + right)/2;
        }
        return doSearch(left, mid, right, target, nums);
    }
}
