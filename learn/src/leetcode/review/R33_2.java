package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R33_2 {
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
// 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如，
// [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
// 示例 1：
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.7 MB,击败了74.00% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int left = 0,right = nums.length-1; left<=right; left++,right--) {
            if(nums[left] == target){
                return left;
            }
            if(nums[right]==target){
                return right;
            }
        }
        return -1;
    }
}
