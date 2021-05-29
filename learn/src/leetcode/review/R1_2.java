package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R1_2 {
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
