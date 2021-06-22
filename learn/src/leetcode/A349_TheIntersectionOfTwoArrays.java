package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * @author: wyj
 * @date: 2021/06/22
 */
public class A349_TheIntersectionOfTwoArrays {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *  示例 1：
     *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *  示例 2：
     *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 			执行耗时:8 ms,击败了13.19% 的Java用户
     * 			内存消耗:38.3 MB,击败了92.50% 的Java用户
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for (int i : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j]==i){
                    set.add(i);
                    break;
                }
            }
        }
        int[] arr=new int[set.size()];
        int index=0;
        for (Integer integer : set) {
            arr[index++]=integer;
        }
        return arr;
    }
}
