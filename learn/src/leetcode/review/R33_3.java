package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R33_3 {
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//			执行耗时:0 ms,击败了100.00% 的Java用户
//			内存消耗:37.9 MB,击败了29.80% 的Java用户
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }else if(nums[i]>target){
                while (i+1<nums.length&&nums[i]<nums[i+1]){
                    i++;
                }
            }
        }
        return -1;
    }
}
