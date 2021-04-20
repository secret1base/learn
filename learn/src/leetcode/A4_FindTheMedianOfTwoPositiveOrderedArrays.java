package leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * @author: wyj
 * @date: 2021/04/20
 */
public class A4_FindTheMedianOfTwoPositiveOrderedArrays {
    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * 提示：
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    public static void main(String[] args) {
        double medianSortedArrays = new A4_FindTheMedianOfTwoPositiveOrderedArrays()
                .findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

    /**
     * 思路：
     * 1、把两个数组的长度相加后，根据相加的和new一个新的数组
     * 2、声明两个指针，left和right，一个index用于记录当前新数组的下标索引
     * 3、当left小于数组1，right小于数组2时，判断left和right的对应值哪个小，哪个小就把小的值放入新数组中
     * 4、当出了第一个while循环后，还存在left或者right数组没有使用完的情况，哪个数组没有使用完就把那个数组中的值全按顺序放入新数组中
     * 执行用时：3 ms, 在所有 Java 提交中击败了82.41%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了84.74%的用户
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length==0){
            return 0;
        }
        int[] array=new int[length];
        int left=0;
        int right=0;
        int index=0;
        while (left<nums1.length&&right < nums2.length){
            if(nums1[left]>nums2[right]){
                array[index++]=nums2[right++];
            }else{
                array[index++] = nums1[left++];
            }
        }
        while (left < nums1.length){
            array[index++]=nums1[left++];
        }
        while (right < nums2.length){
            array[index++]=nums2[right++];
        }
        int i = length % 2;
        if(i==1){
            //123 =>/2 =>3/2=>1 下标从0,1,2刚好为1
             return array[length/2];
        }else{
            //1234 =>/2=>4/2=>2 下标0,1,2,3
            int a = length / 2;
            //注意不要除2需要除以2.0，区别就是5/2=2，5/2.0=2.5
            return (array[a-1]+array[a])/2.0;
        }
    }
}
