package leetcode;

/**
 * 75. 颜色分类
 * @author: wyj
 * @date: 2021/06/29
 */
public class A75_ColorClassification {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *  此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *  示例 1：
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     *  示例 2：
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     *  示例 3：
     * 输入：nums = [0]
     * 输出：[0]
     *  示例 4：
     * 输入：nums = [1]
     * 输出：[1]
     *
     * 		执行耗时:1 ms,击败了13.54% 的Java用户
     * 		内存消耗:36.6 MB,击败了97.49% 的Java用户
     */
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    int num = nums[i];
                    nums[i]=nums[j];
                    nums[j]=num;
                }
            }
        }
    }
}
