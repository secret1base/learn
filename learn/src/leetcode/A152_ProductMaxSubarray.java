package leetcode;

/**
 * 152. 乘积最大子数组
 * @author: wyj
 * @date: 2021/06/24
 */
public class A152_ProductMaxSubarray {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *  示例 1:
     *  输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *  示例 2:
     *  输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    /**
     * 动态规划
     * 只是理解，并不是自己推导出来的代码
     * 		执行耗时:1 ms,击败了98.30% 的Java用户
     * 		内存消耗:38.3 MB,击败了29.39% 的Java用户
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        System.arraycopy(nums,0,max,0,nums.length);
        System.arraycopy(nums,0,min,0,nums.length);
        for (int i = 1; i < nums.length; i++) {
            max[i]=Math.max(max[i-1]*nums[i],Math.max(nums[i],min[i-1]*nums[i]));
            min[i]=Math.min(min[i-1]*nums[i],Math.min(nums[i],max[i-1]*nums[i]));
        }
        int m=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            m=Math.max(m,max[i]);
        }
        return m;
    }
//    /**
//     * 枚举：答案正确，但是超时
//     */
//    public int maxProduct(int[] nums) {
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length;i++){
//            Integer multi=null;
//            for (int j = i; j < nums.length;j++){
//                if(multi==null){
//                    multi=nums[j];
//                }else{
//                    multi*=nums[j];
//                }
//                max=Math.max(max,multi);
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        int i = new A152_ProductMaxSubarray().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);
    }
}
