package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R1_3 {
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length;i++){
            for (int j = i+1; j < nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
