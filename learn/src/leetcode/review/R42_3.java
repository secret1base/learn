package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/17
 */
public class R42_3 {
    /**
     * 			执行耗时:1 ms,击败了99.99% 的Java用户
     * 			内存消耗:37.7 MB,击败了96.42% 的Java用户
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int max=0;
        for (int i = 0; i < height.length; i++) {
            left[i]=max=Math.max(max,height[i]);
        }
        int[] right=new int[height.length];
        max=0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i]=max=Math.max(max,height[i]);
        }
        int sum=0;
        for (int i = 0; i < height.length; i++) {
            sum+=Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
