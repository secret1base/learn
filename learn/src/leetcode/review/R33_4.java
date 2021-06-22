package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R33_4 {
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.7 MB,击败了81.74% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
            if(i+1<nums.length&&nums[i]>nums[i+1]){
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j]==target){
                        return j;
                    }else if(nums[j]>target){
                        return -1;
                    }
                }
            }
        }
        return -1;
    }
}
