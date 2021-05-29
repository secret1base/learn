package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R4_1 {
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
// 请你找出并返回这两个正序数组的 中位数 。
// 示例 1：
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 示例 2：
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 示例 3：
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 示例 4：
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 示例 5：
//输入：nums1 = [2], nums2 = []
//输出：2.00000

    /**
     * 			执行耗时:3 ms,击败了82.29% 的Java用户
     * 			内存消耗:40 MB,击败了5.45% 的Java用户
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int x=0;
        int y=0;
        int index=0;
        while (x<nums1.length&&y<nums2.length){
            if(nums1[x]<nums2[y]){
                arr[index++]=nums1[x++];
            }else{
                arr[index++]=nums2[y++];
            }
        }
        while (x<nums1.length){
            arr[index++]=nums1[x++];
        }
        while (y<nums2.length){
            arr[index++]=nums2[y++];
        }
        int left=0;
        int right = arr.length-1;
        int i=left + right;
        int mid = i / 2;
        int a = i % 2;
        if(a==0){
            return arr[mid];
        }else{
            return (arr[mid]+arr[mid+1])/2.0;
        }
    }
}
