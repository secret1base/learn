package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * @author: wyj
 * @date: 2021/07/12
 */
public class A260_TheNumberIIIAppearsOnlyOnce {
    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     *  进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
     *  示例 1：
     * 输入：nums = [1,2,1,3,2,5]
     * 输出：[3,5]
     * 解释：[5, 3] 也是有效的答案。
     *  示例 2：
     * 输入：nums = [-1,0]
     * 输出：[-1,0]
     *  示例 3：
     * 输入：nums = [0,1]
     * 输出：[1,0]
     *  提示：
     *  2 <= nums.length <= 3 * 104
     *  -231 <= nums[i] <= 231 - 1
     *  除两个只出现一次的整数外，nums 中的其他数字都出现两次
     *
     *  一次过，就是效率有点低
     *  		执行耗时:5 ms,击败了18.40% 的Java用户
     * 			内存消耗:39.5 MB,击败了13.09% 的Java用户
     *
     */
    public int[] singleNumber(int[] nums) {
        //借助map,因为最多也就是两次(不存在三次的)，因此一旦达到两次就移除
        Map<Integer,Integer> map=new HashMap<>();
        int size=0;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if(count==1){
                map.remove(num);
                size--;
            }else{
                map.put(num,count+1);
                size++;
            }
        }
        Object[] objs = map.keySet().toArray();
        int[] arr=new int[objs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(objs[i].toString());
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new A260_TheNumberIIIAppearsOnlyOnce().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));
    }
}
