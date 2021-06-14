package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R1_4 {
    //		执行耗时:61 ms,击败了6.20% 的Java用户
    //		内存消耗:38.8 MB,击败了20.14% 的Java用户
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
