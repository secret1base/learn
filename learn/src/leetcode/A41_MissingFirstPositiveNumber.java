package leetcode;

/**
 * 41. 缺失的第一个正数
 * @author: wyj
 * @date: 2021/04/28
 */
public class A41_MissingFirstPositiveNumber {
    /**
     * 41. 缺失的第一个正数
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * 提示：
     * 0 <= nums.length <= 300
     * -231 <= nums[i] <= 231 - 1
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 0};
        int i = new A41_MissingFirstPositiveNumber().firstMissingPositive(ints);
        System.out.println(i);
    }

    /**
     * 执行耗时:2 ms,击败了8.63% 的Java用户
     * 内存消耗:35.9 MB,击败了93.28% 的Java用户
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //先排序，然后从1开始找
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    int tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i] = tmp;
                }
            }
        }
        int a=1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0){
                continue;
            }else if(nums[i]==a){
                a++;
            }else if(nums[i] > a){
                //一但nums大于0并且大于a，说明a就是要找的最小值
                return a;
            }
        }
        return a;
    }
}
