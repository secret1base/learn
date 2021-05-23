package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.多数元素
 * @author: wyj
 * @date: 2021/05/21
 */
public class A169_MostElements {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *  示例 1：
     * 输入：[3,2,3]
     * 输出：3
     *  示例 2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *  进阶：
     *  尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     * @param nums
     * @return
     */
    /**
     * 			执行耗时:15 ms,击败了21.19% 的Java用户
     * 			内存消耗:43.4 MB,击败了42.79% 的Java用户
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int target = n / 2;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            if(orDefault+1>target){
                return nums[i];
            }
            map.put(nums[i],orDefault+1);
        }
        return -1;
    }
}
