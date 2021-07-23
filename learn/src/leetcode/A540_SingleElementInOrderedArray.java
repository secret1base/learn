package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 540. 有序数组中的单一元素
 * @author: wyj
 * @date: 2021/07/16
 */
public class A540_SingleElementInOrderedArray {
    /**
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     *  示例 1:
     * 输入: [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     *  示例 2:
     * 输入: [3,3,7,7,10,11,11]
     * 输出: 10
     * @param nums
     * @return
     *
     *      执行耗时:5 ms,击败了8.23% 的Java用户
     * 		内存消耗:40 MB,击败了5.13% 的Java用户
     */
    public int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if(integer==null){
                map.put(num,1);
            }else{
                map.remove(num);
            }
        }
        for (Integer integer : map.keySet()) {
            return integer;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new A540_SingleElementInOrderedArray().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
        System.out.println(i);
    }
}
