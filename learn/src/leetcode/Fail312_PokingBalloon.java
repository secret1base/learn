//package leetcode;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
///**
// * 312. 戳气球
// * @author: wyj
// * @date: 2021/07/16
// */
//public class Fail312_PokingBalloon {
//    /**
//     * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//     *  现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
//     *  1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
//     *  求所能获得硬币的最大数量。
//     * 示例 1：
//     * 输入：nums = [3,1,5,8]
//     * 输出：167
//     * 解释：
//     * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//     * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
//     *  示例 2：
//     * 输入：nums = [1,5]
//     * 输出：10
//     *  提示：
//     *  n == nums.length
//     *  1 <= n <= 500
//     *  0 <= nums[i] <= 100
//     */
//    /**
//     * 答案正确，但又超时
//     */
//    int max=0;
//    public int maxCoins(int[] nums) {
//        Deque<Integer> path=new LinkedList<>();
//        boolean[] used=new boolean[nums.length];
//        poking(nums,path,used);
//        return max;
//    }
//
//    private void poking(int[] nums, Deque<Integer> path, boolean[] used) {
//        if(path.size()==nums.length){
//            int sum=0;
//            for (Integer a : path) {
//                sum+=a;
//            }
//            max=Math.max(max,sum);
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if(!used[i]){
//                used[i]=true;
//                //找到i左右两边没破的气球
//                int left=1;
//                int right=1;
//                int l=i-1;
//                while (l>=0){
//                    if(!used[l]){
//                        left=nums[l];
//                        break;
//                    }else{
//                        l--;
//                    }
//                }
//                int r=i+1;
//                while (r<nums.length){
//                    if(!used[r]){
//                        right=nums[r];
//                        break;
//                    }else{
//                        r++;
//                    }
//                }
//                path.offerLast(left*nums[i]*right);
//                poking(nums,path,used);
//                path.pollLast();
//                used[i]=false;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int i = new Fail312_PokingBalloon().maxCoins(new int[]{3, 1, 5, 8});
//        System.out.println(i);
//    }
//}
