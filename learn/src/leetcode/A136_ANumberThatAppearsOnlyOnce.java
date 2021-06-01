package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * @author: wyj
 * @date: 2021/06/01
 */
public class A136_ANumberThatAppearsOnlyOnce {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *  说明：
     *  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *  示例 1:
     *  输入: [2,2,1]
     * 输出: 1
     *  示例 2:
     *  输入: [4,1,2,1,2]
     * 输出: 4
     * @param nums
     * @return
     */
    /**
     * 		执行耗时:8 ms,击败了24.32% 的Java用户
     * 		内存消耗:38.5 MB,击败了70.28% 的Java用户
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(((i+1<nums.length&&nums[i] != nums[i+1])||i==nums.length-1)&&((i>0&&nums[i]!=nums[i-1])||i==0)){
                //和后一个元素不相等(或者没有后一个元素)且和前一个元素不相等(或者前面没有元素),这时i的前面和后面都不相等则i只有一个
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new A136_ANumberThatAppearsOnlyOnce().singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }
}
