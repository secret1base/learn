package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R121_2 {
    /**
     * 			执行耗时:4 ms,击败了27.47% 的Java用户
     * 			内存消耗:47.8 MB,击败了99.39% 的Java用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] left=new int[prices.length];
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            left[i]=min=Math.min(prices[i], min);
        }
        int[] right=new int[prices.length];
        int max=0;
        for (int i = prices.length - 1; i >= 0; i--) {
            right[i]=max=Math.max(prices[i], max);
        }
        max=0;
        for (int i = 0; i < prices.length; i++) {
            max=Math.max(max,right[i]-left[i]);
        }
        return max;
    }
}
