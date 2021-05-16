package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R121_1 {
    //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
    public static void main(String[] args) {
        System.out.println(new R121_1().maxProfit(new int[]{1,6,4,3,7}));
    }

    /**
     * 	执行耗时:4 ms,击败了27.42% 的Java用户
     * 	内存消耗:47.6 MB,击败了99.75% 的Java用户
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            left[i] = min=Math.min(prices[i],min);
        }
        int max=0;
        for (int i = prices.length-1; i >= 0; i--) {
            right[i] = max=Math.max(prices[i],max);
        }
        int r=0;
        for(int i = 0; i < prices.length; i++){
            r=Math.max(right[i]-left[i],r);
        }
        return r;
    }
}
