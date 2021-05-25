package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R718_2 {
    //A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    int tmp=1;
                    int a=i+1;
                    int b=j+1;
                    while (a<nums1.length&&b<nums2.length){
                        if(nums1[a]==nums2[b]){
                            tmp++;
                            a++;
                            b++;
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
