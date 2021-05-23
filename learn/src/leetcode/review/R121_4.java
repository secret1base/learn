package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R121_4 {
    public int maxProfit(int[] prices) {
        //获取对于当前节点来说最小的价格left[i]和最大的价格right[i]
        int[] left=new int[prices.length];
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            left[i]=min=Math.min(min,prices[i]);
        }
        int[] right=new int[prices.length];
        int max=0;
        for (int i = prices.length - 1; i >= 0; i--) {
            right[i]=max=Math.max(max,prices[i]);
        }
        max=0;
        for(int i = 0; i < prices.length; i++){
            max=Math.max(right[i] -left[i],max);
        }
        return max;
    }
}
