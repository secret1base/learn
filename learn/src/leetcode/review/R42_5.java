package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R42_5 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int max=0;
        for (int i = 0; i < height.length; i++) {
            left[i]=max=Math.max(max,height[i]);
        }
        int[] right = new int[height.length];
        max=0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i]=max=Math.max(max,height[i]);
        }
        int sum=0;
        for (int i = 0; i < height.length; i++) {
            sum+=Math.min(left[i], right[i])-height[i];
        }
        return sum;
    }
}
