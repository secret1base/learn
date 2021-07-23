package leetcode;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * @author: wyj
 * @date: 2021/07/19
 */
public class A350_IntersectionOfTwoArraysII {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *  示例 1：
     *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     *  示例 2:
     *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  说明：
     *  输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     *  我们可以不考虑输出结果的顺序。
     *  进阶：
     *  如果给定的数组已经排好序呢？你将如何优化你的算法？
     *  如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     *  如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     *  		执行耗时:4 ms,击败了33.21% 的Java用户
     * 			内存消耗:38.6 MB,击败了51.45% 的Java用户
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for (int a : nums1) {
            Integer c = map1.getOrDefault(a, 0);
            map1.put(a,c+1);
        }
        for (int a : nums2) {
            Integer c = map2.getOrDefault(a, 0);
            map2.put(a,c+1);
        }
        List<Integer> list=new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if(map2.get(key)!=null){
                int min = Math.min(map1.get(key), map2.get(key));
                for (int i=0;i<min;i++){
                    list.add(key);
                }
            }
        }
        int[] arr=new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] intersect = new A350_IntersectionOfTwoArraysII().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersect));
    }
}
