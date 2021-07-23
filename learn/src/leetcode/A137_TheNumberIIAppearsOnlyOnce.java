package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * @author: wyj
 * @date: 2021/07/15
 */
public class A137_TheNumberIIAppearsOnlyOnce {
    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *  示例 1：
     * 输入：nums = [2,2,3,2]
     * 输出：3
     *  示例 2：
     * 输入：nums = [0,1,0,1,0,1,99]
     * 输出：99
     *  提示：
     *  1 <= nums.length <= 3 * 104
     *  -231 <= nums[i] <= 231 - 1
     *  nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     *
     *  		执行耗时:5 ms,击败了43.31% 的Java用户
     * 			内存消耗:38.1 MB,击败了76.31% 的Java用户
     *
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer c = map.getOrDefault(num, 0);
            if(c==2){
                map.remove(num);
            }else{
                map.put(num,c+1);
            }
        }
        for (Integer integer : map.keySet()) {
            return integer;
        }
        return -1;
    }
}
