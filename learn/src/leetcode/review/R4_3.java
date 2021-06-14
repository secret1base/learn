package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R4_3 {
    //输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
    //			执行耗时:4 ms,击败了25.13% 的Java用户
    //			内存消耗:39.8 MB,击败了34.86% 的Java用户
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int x=0;
        int y=0;
        int index=0;
        while (x<nums1.length||y<nums2.length){
            int a=x<nums1.length?nums1[x]:Integer.MAX_VALUE;
            int b=y<nums2.length?nums2[y]:Integer.MAX_VALUE;
            if(a<b){
                arr[index++]=nums1[x++];
            }else{
                arr[index++]=nums2[y++];
            }
        }
        int length = arr.length;
        int mid = length / 2;
        if(length%2==1){
            return arr[mid];
        }else{
            return (arr[mid]+arr[mid-1])/2.0;
        }
    }

    public static void main(String[] args) {
        new R4_3().findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}
