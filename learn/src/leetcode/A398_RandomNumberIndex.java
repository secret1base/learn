package leetcode;

import java.util.*;

/**
 * 398. 随机数索引
 * @author: wyj
 * @date: 2021/07/28
 */
public class A398_RandomNumberIndex {
    /**
     * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
     *  注意：
     * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
     *  示例:
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     *
     * 一次过
     * 			执行耗时:77 ms,击败了31.51% 的Java用户
     * 			内存消耗:48.5 MB,击败了9.29% 的Java用户
     */
    Map<Integer, List<Integer>> map=new HashMap<>();
    public A398_RandomNumberIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.get(num);
            if(list==null){
                list=new ArrayList<>();
            }
            list.add(i);
            map.put(num,list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random random=new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
