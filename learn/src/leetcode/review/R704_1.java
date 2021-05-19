package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R704_1 {
    public static void main(String[] args) {
        int search = new R704_1().search(new int[]{1, 2, 3, 4, 5}, -3);
        System.out.println(search);
    }
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        return doSearch(left,mid,right,nums,target);
    }

    private int doSearch(int left, int mid, int right, int[] nums, int target) {
        if(nums[left]>target||nums[right] < target){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid] >target){
            right=mid-1;
        }else{
            left=mid+1;
        }
        mid=(left+right)/2;
        return doSearch(left,mid,right,nums,target);
    }
}
