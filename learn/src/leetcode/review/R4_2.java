package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R4_2 {
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
     * 			执行耗时:3 ms,击败了82.30% 的Java用户
     * 			内存消耗:39.5 MB,击败了82.51% 的Java用户
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int left=0;
        int right=0;
        int index=0;
        while (left<nums1.length&&right<nums2.length){
            if(nums1[left]<nums2[right]){
                arr[index++]=nums1[left++];
            }else{
                arr[index++]=nums2[right++];
            }
        }
        while (left<nums1.length){
            arr[index++]=nums1[left++];
        }
        while (right<nums2.length){
            arr[index++]=nums2[right++];
        }
        int mid = arr.length / 2;
        if(arr.length%2==0){
            return (arr[mid-1]+arr[mid])/2.0;
        }else{
            return arr[mid];
        }
    }

    public static void main(String[] args) {
        double medianSortedArrays = new R4_2().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
}
