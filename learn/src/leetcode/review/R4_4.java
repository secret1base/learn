package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R4_4 {
    public static void main(String[] args) {
        double medianSortedArrays = new R4_4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }

    /**
     * 			执行耗时:3 ms,击败了82.90% 的Java用户
     * 			内存消耗:39.7 MB,击败了51.14% 的Java用户
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
        int length = arr.length;
        int mid = length / 2;
        if(length%2==1){
            //5
            return arr[mid];
        }else{
            return (arr[mid-1]+arr[mid])/2.0;
        }
    }
}
