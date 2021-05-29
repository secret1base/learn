package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R718_4 {
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
public static void main(String[] args) {
    int length = new R718_4().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
    System.out.println(length);
}

    /**
     * 		执行耗时:2273 ms,击败了5.32% 的Java用户
     * 		内存消耗:38.2 MB,击败了83.98% 的Java用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]){
                    int tmp=1;
                    int left=i+1;
                    int right=j+1;
                    while (left<nums1.length&&right<nums2.length){
                        if(nums1[left]==nums2[right]){
                            tmp++;
                            left++;
                            right++;
                        }else{
                            break;
                        }
                    }
                    max=Math.max(max,tmp);
                }
            }
        }
        return max;
    }
}
