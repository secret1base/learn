package leetcode;

/**
 * 718.最长重复子数组
 * @author: wyj
 * @date: 2021/05/20
 */
public class A718_LongestRepeatingSubarray {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *  示例：
     *  输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1] 。
     */
    public static void main(String[] args) {
        int length = new A718_LongestRepeatingSubarray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
        System.out.println(length);
    }

    /**
     * 		执行耗时:168 ms,击败了5.35% 的Java用户
     * 		内存消耗:37.9 MB,击败了96.16% 的Java用户
     * 下次解题用动态规划来解题
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        for (int i = 0; i < nums1.length;i++){
            for (int j = 0; j < nums2.length;j++){
                //剪枝，当两个数组的剩余长度的最小值比max小，那就没有继续找下去的必要了
                if(Math.min(nums2.length-j,nums1.length-i)<=max){
                    break;
                }
                if(nums1[i]==nums2[j]){
                    max=Math.max(getLength(i,j,nums1,nums2),max);
                }
            }
        }
        return max;
    }

    private int getLength(int i, int j, int[] nums1, int[] nums2) {
        int index=0;
        while (i<nums1.length&&j<nums2.length&&nums1[i] == nums2[j]){
            i++;
            j++;
            index++;
        }
        return index;
    }
}
