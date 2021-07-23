package leetcode;

import java.util.*;

/**
 * 658. 找到 K 个最接近的元素
 * @author: wyj
 * @date: 2021/07/23
 */
public class A658_FindKClosestElements {
    /**
     * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *  整数 a 比整数 b 更接近 x 需要满足：
     *  |a - x| < |b - x| 或者
     *  |a - x| == |b - x| 且 a < b
     *  示例 1：
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     *  示例 2：
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     *  提示：
     *  1 <= k <= arr.length
     *  1 <= arr.length <= 104
     *  数组里的每个元素与 x 的绝对值不超过 104
     * 			执行耗时:18 ms,击败了20.77% 的Java用户
     * 			内存消耗:40.8 MB,击败了15.41% 的Java用户
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        X[] list = new X[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - x);
            X a=new X(abs,i);
            list[i]=a;
        }
        Arrays.sort(list, new Comparator<X>() {
            @Override
            public int compare(X o1, X o2) {
                return Integer.compare(o1.val,o2.val);
            }
        });
        List<Integer> ls=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ls.add(arr[list[i].index]);
        }
        Collections.sort(ls);
        return ls;
    }
    class X{
        int val;
        int index;

        public X(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
