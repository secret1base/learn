package leetcode;

/**
 * 55. 跳跃游戏
 * @author: wyj
 * @date: 2021/07/02
 */
public class A55_JumpGame {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *  数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *  判断你是否能够到达最后一个下标。
     *  示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *  示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     */
    public boolean canJump(int[] nums) {
        //能跳到的最远距离
        /**
         * 解题思路
         * 1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
         * 2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
         * 3、如果可以一直跳到最后，就成功了。
         */
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(i>max){
                return false;
            }
            max=Math.max(i+nums[i],max);
        }
        return true;
    }
//    /**
//     * 回溯算法
//     * 超时了
//     */
//    boolean flag=false;
//    public boolean canJump(int[] nums) {
//        //到达终点
//        canJump(0,nums);
//        return flag;
//    }
//
//    private boolean canJump(int index, int[] nums) {
//        if(index==nums.length-1||flag==true){
//            flag=true;
//            return true;
//        }else if(index>nums.length-1){
//            return false;
//        }
//        int num = nums[index];//可以跳[1,num]步 1 2 3
//        for (int j = 1; j <= num; j++) {
//            if(canJump(index+j,nums)){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new A55_JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));//false
        System.out.println(new A55_JumpGame().canJump(new int[]{2,3,1,1,4}));//true
        System.out.println(new A55_JumpGame().canJump(new int[]{0,2,3}));//false
    }
}
