package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R704_3 {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=left+(right - left)/2;
        return doSearch(left,mid,right,target,nums);
    }

    private int doSearch(int left, int mid, int right, int target, int[] nums) {
        if(nums[left]>target||nums[right] < target){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            right=mid-1;
        }else{
            left=mid+1;
        }
        mid=left+(right-left)/2;
        return doSearch(left,mid,right,target,nums);
    }
}
