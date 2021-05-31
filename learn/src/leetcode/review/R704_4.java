package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R704_4 {
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.1 MB,击败了88.50% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(nums[left]>target||nums[right]<target){
                return -1;
            }
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
