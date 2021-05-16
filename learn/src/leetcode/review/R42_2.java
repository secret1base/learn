package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R42_2 {
    /**
     * 			执行耗时:1 ms,击败了99.99% 的Java用户
     * 			内存消耗:37.9 MB,击败了78.66% 的Java用户
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int max=0;
        for (int i = 0; i < height.length; i++) {
            left[i]=max = Math.max(height[i],max);
        }
        max=0;
        for (int i = height.length - 1; i >=0; i--) {
            right[i]=max = Math.max(height[i],max);
        }
        max=0;
        for (int i = 0; i < height.length; i++) {
            max+=Math.min(left[i],right[i])-height[i];
        }
        return max;
    }
}
