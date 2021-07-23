package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. 存在重复元素
 * @author: wyj
 * @date: 2021/07/22
 */
public class A217_ThereAreDuplicateElements {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *  如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *  示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     *  示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     *  示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     *
     * 			执行耗时:9 ms,击败了21.59% 的Java用户
     * 			内存消耗:44.6 MB,击败了19.25% 的Java用户
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if(integer==null){
                map.put(num, 1);
            }else{
                return true;
            }
        }
        return false;
    }
}
