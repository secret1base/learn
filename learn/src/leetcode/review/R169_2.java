package leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R169_2 {
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
// 示例 1：
//输入：[3,2,3]
//输出：3

    /**
     * 		执行耗时:15 ms,击败了21.24% 的Java用户
     * 		内存消耗:43.6 MB,击败了41.90% 的Java用户
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            if(orDefault+1>mid){
                return nums[i];
            }
            map.put(nums[i],orDefault+1);
        }
        return -1;
    }
}
