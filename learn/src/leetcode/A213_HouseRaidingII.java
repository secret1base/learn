package leetcode;

/**
 * 213. 打家劫舍 II
 * @author: wyj
 * @date: 2021/06/24
 */
public class A213_HouseRaidingII {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
     * 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *  给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     *  示例 1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *  示例 2：
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *  示例 3：
     * 输入：nums = [0]
     * 输出：0
     */
    /**
     * 动态规划,需要注意的是他们围成了一个圈
     * @param nums
     * @return
     *
     *          执行耗时:2 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.6 MB,击败了93.07% 的Java用户
     */
    public int rob(int[] nums) {
        //注意首位也算相邻，因此需要划分成两部分0,n-1和1，n
        //标记所有
        int[] store=new int[nums.length];
        int[] store2=new int[nums.length];
        System.arraycopy(nums,0,store,0,nums.length);
        System.arraycopy(nums,0,store2,0,nums.length);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++){
            //不能相邻，注意首位也算相邻
            for (int j = 0; j < i-1; j++) {
                store[i]=Math.max(store[j]+nums[i],store[i]);
            }
        }
        for (int i = 1; i < nums.length; i++){
            //不能相邻，注意首位也算相邻
            for (int j = 1; j < i-1; j++) {
                store2[i]=Math.max(store2[j]+nums[i],store2[i]);
            }
        }
        for (int i : store2) {
            max=Math.max(max,i);
        }
        for (int i : store) {
            max=Math.max(max,i);
        }
        return max;
    }

    public static void main(String[] args) {
//        int rob = new A213_HouseRaidingII().rob(new int[]{2, 3, 2});
        int rob = new A213_HouseRaidingII().rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }
}
