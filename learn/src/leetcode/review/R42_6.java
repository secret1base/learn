package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R42_6 {
    /**
     * 			执行耗时:1 ms,击败了99.99% 的Java用户
     * 			内存消耗:38.1 MB,击败了58.50% 的Java用户
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if(i-1>=0){
                left[i]=Math.max(left[i-1],height[i]);
            }else{
                left[i]=height[i];
            }
        }
        for (int i = height.length-1; i >=0; i--) {
            if(i==height.length-1){
                right[i]=height[i];
            }else{
                right[i]=Math.max(right[i+1],height[i]);
            }
        }
        int sum=0;
        for (int i = 0; i < height.length;i++){
            sum+=Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }
}
