package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 287. 寻找重复数
 * @author: wyj
 * @date: 2021/06/23
 */
public class A287_LookForRepeats {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     *  假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     *  你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     *  示例 1：
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     *  示例 2：
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     *  示例 3：
     * 输入：nums = [1,1]
     * 输出：1
     *  示例 4：
     * 输入：nums = [1,1,2]
     * 输出：1
     *
     * 			执行耗时:27 ms,击败了22.82% 的Java用户
     * 			内存消耗:51 MB,击败了50.11% 的Java用户
     */
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if(integer!=null){
                return num;
            }else{
                map.put(num,1);
            }
        }
        return -1;
    }
}
