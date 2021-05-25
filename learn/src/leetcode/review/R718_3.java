package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R718_3 {
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
// 示例：
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    int tmp=1;
                    int a=i+1;
                    int b=j+1;
                    while (a<nums1.length&&b<nums2.length){
                        if(nums1[a] == nums2[b]){
                            tmp++;
                            a++;
                            b++;
                        }else{
                            break;
                        }
                    }
                    max=Math.max(tmp,max);
                }
            }
        }
        return max;
    }
}
