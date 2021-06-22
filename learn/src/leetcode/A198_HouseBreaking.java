package leetcode;

/**
 * 198. 打家劫舍
 * @author: wyj
 * @date: 2021/06/17
 */
public class A198_HouseBreaking {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
     * 被小偷闯入，系统会自动报警。
     *  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *  示例 1：
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *  示例 2：
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */
    /**
     * 动态规划
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.7 MB,击败了79.56% 的Java用户
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        /**
         * 只有一间时只能拿一间
         * 有两间时取两间中的最大值
         * 有4间时1,2,3,4，第4间取1和2中的最大值+4
         */
        int[] store=new int[nums.length];
        int max=0;
        for (int i = 0; i < nums.length; i++){
            if(i<2){
                //前面两间房间能够拿到的金额只能是当前房间的金额
                store[i]=nums[i];
            }else{
                int tmpMax=0;
                //当前位置为i时，找到i-1前面(不包含i-1)的最大值
                for (int j = 0; j < i-1; j++) {
                    tmpMax=Math.max(tmpMax,store[j]);
                }
                store[i] = tmpMax+nums[i];
            }
            max=Math.max(max,store[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int rob = new A198_HouseBreaking().rob(new int[]{2,7,9,3,1});
        System.out.println(rob);
    }

//回溯算法超时
//    int max=0;
//    public int rob(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            robMoney(i,nums[i],nums);
//        }
//        return max;
//    }
//
//    private void robMoney(int i, int sum, int[] nums) {
//        if(i+2>=nums.length){
//            max=Math.max(max,sum);
//            return;
//        }
//        //间隔一位
//        for (int j = i+2; j < nums.length; j++) {
//            robMoney(j,sum+nums[j],nums);
//        }
//    }
}
