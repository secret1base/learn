package leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R169_1 {
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
// 示例 1：
//输入：[3,2,3]
//输出：3
// 示例 2：
//输入：[2,2,1,1,1,2,2]
//输出：2
    public int majorityElement(int[] nums) {
        int count = nums.length / 2;
        Map<Integer,Integer> data=new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            Integer c = data.getOrDefault(nums[i], 0);
            if(c+1>count){
                return nums[i];
            }
            data.put(nums[i], c+1);
        }
        return 0;
    }
}
