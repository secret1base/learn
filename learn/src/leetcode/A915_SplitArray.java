package leetcode;

/**
 * 915. 分割数组
 * @author: wyj
 * @date: 2021/07/27
 */
public class A915_SplitArray {
    /**
     * 给定一个数组 A，将其划分为两个连续子数组 left 和 right， 使得：
     *  left 中的每个元素都小于或等于 right 中的每个元素。
     *  left 和 right 都是非空的。
     *  left 的长度要尽可能小。
     *  在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
     *  示例 1：
     * 输入：[5,0,3,8,6]
     * 输出：3
     * 解释：left = [5,0,3]，right = [8,6]
     *  示例 2：
     * 输入：[1,1,1,0,6,12]
     * 输出：4
     * 解释：left = [1,1,1,0]，right = [6,12]
     *  提示：
     *  2 <= A.length <= 30000
     *  0 <= A[i] <= 10^6
     *  可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
     *
     *  方向对了，调试后一次过
     *  		执行耗时:3 ms,击败了50.00% 的Java用户
     * 			内存消耗:43.1 MB,击败了60.05% 的Java用户
     *
     */
    public int partitionDisjoint(int[] nums) {
        //从左侧开始的最大值
        int[] left=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                left[i]=nums[i];
            }else{
                left[i]=Math.max(left[i-1],nums[i]);
            }
        }
        //从右侧开始的最小值
        int[] right=new int[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            if(i==nums.length-1){
                right[i]=nums[i];
            }else{
                right[i]=Math.min(nums[i],right[i+1]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1<nums.length&&left[i]<=right[i+1]){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new A915_SplitArray().partitionDisjoint(new int[]{5, 0, 3, 8, 6});
        System.out.println(i);
    }
}
