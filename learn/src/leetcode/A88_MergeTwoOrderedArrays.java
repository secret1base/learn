package leetcode;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * @author: wyj
 * @date: 2021/05/15
 */
public class A88_MergeTwoOrderedArrays {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
     * ms2 的元素。
     *  示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     *  示例 2：
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *  提示：
     *  nums1.length == m + n
     *  nums2.length == n
     *  0 <= m, n <= 200
     *  1 <= m + n <= 200
     *  -109 <= nums1[i], nums2[i] <= 109
     */
    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 0, 0};
        new A88_MergeTwoOrderedArrays().merge(ints,3,new int[]{2,4},2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 倒序移动位置
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.4 MB,击败了85.78% 的Java用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //记录当前需要被移动的nums1的索引位置
        int index=m+n-1;
        m--;
        n--;
        for (int i = index; i >= 0&&m>=0&&n>=0; i--,index--) {
            int a = nums1[m];
            int b = nums2[n];
            if(a>b){
                nums1[i]=a;
                m--;
            }else{
                nums1[i]=b;
                n--;
            }
        }
        while (m>=0){
            nums1[index--]=nums1[m--];
        }
        while (n>=0){
            nums1[index--]=nums2[n--];
        }
    }
}
