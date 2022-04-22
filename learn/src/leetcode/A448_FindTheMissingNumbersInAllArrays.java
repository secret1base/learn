package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 448. 找到所有数组中消失的数字
 * @author: wyj
 * @date: 2021/07/27
 */
public class A448_FindTheMissingNumbersInAllArrays {
    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *  示例 1：
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     *  示例 2：
     * 输入：nums = [1,1]
     * 输出：[2]
     *  提示：
     *  n == nums.length
     *  1 <= n <= 105
     *  1 <= nums[i] <= n
     *  进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     *  Related Topics 数组 哈希表
     *
     *  		执行耗时:23 ms,击败了9.47% 的Java用户
     * 			内存消耗:48.2 MB,击败了5.05% 的Java用户
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <=nums.length; i++) {
            map.put(i,1);
        }
        for (int num : nums) {
            map.remove(num);
        }
        List<Integer> list=new ArrayList<>();
        for (Integer a : map.keySet()) {
            list.add(a);
        }
        return list;
    }
}
