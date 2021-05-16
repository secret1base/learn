package leetcode;

/**
 * 53.最大子序和
 * @author: wyj
 * @date: 2021/05/14
 */
public class A53_MaximalSuborderSum {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *  示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *  示例 2：
     * 输入：nums = [1]
     * 输出：1
     *  示例 3：
     * 输入：nums = [0]
     * 输出：0
     *  示例 4：
     * 输入：nums = [-1]
     * 输出：-1
     *  示例 5：
     * 输入：nums = [-100000]
     * 输出：-100000
     *  提示：
     *  1 <= nums.length <= 3 * 104
     *  -105 <= nums[i] <= 105
     */
    /**
     * 双指针，左右移动，舍去负号，当left 1 -2 0 时从left向右边移动到0的位置
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        int i = new A53_MaximalSuborderSum().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    /**
     * 暴力破解，遍历出所有可能
     * 执行耗时:541 ms,击败了5.08% 的Java用户
     * 内存消耗:38.5 MB,击败了34.29% 的Java用户
     * 注：一开始考虑使用双指针，但是没能找到进一步的规律，无法进行解答
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        Integer max=null;
        for (int i = 0; i < nums.length; i++) {
            int tmp=0;
            for (int j = i; j < nums.length; j++) {
                tmp+=nums[j];
                if(max==null){
                    max=tmp;
                }else{
                    max=Math.max(max,tmp);
                }
            }
        }
        return max;
    }
}
