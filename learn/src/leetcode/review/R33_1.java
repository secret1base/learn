package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R33_1 {
//整数数组 nums 按升序排列，数组中的值 互不相同 。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如，
// [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
public static void main(String[] args) {
    int search = new R33_1().search(new int[]{1}, 1);
    System.out.println(search);
}

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.7 MB,击败了76.11% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }else if(i+1<nums.length&&nums[i]>nums[i+1]){
                int left=i+1;
                int right=nums.length-1;
                int mid=left+(right-left)/2;
                return binarySearch(i+1,mid,nums.length - 1,nums,target);
            }
        }
        return -1;
    }

    private int binarySearch(int left, int mid, int right, int[] nums, int target) {
        if(nums[mid]==target){
            return mid;
        }else if(target<nums[left]||target>nums[right]){
            return -1;
        }else{
            if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
            mid=left+(right-left)/2;
            return binarySearch(left,mid,right,nums,target);
        }
    }
}
