package leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @author: wyj
 * @date: 2021/06/02
 */
public class A322_ChangeExchange {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
     *  -1。
     *  你可以认为每种硬币的数量是无限的。
     *  示例 1：
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *  示例 2：
     * 输入：coins = [2], amount = 3
     * 输出：-1
     *  示例 3：
     * 输入：coins = [1], amount = 0
     * 输出：0
     *  示例 4：
     * 输入：coins = [1], amount = 1
     * 输出：1
     *  示例 5：
     * 输入：coins = [1], amount = 2
     * 输出：2
     *  提示：
     *  1 <= coins.length <= 12
     *  1 <= coins[i] <= 231 - 1
     *  0 <= amount <= 104
     */
    /**
     * 这题很难，应该在困难难度
     * 			执行耗时:16 ms,击败了62.53% 的Java用户
     * 			内存消耗:37.9 MB,击败了56.07% 的Java用户
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //动态规划算法
        //amount+1的含义为假定coins中有1则可能存在的最多硬币数为amount个，包含0则最多存在amount+1种解法
        int[] store=new int[amount+1];
        //填充最多的硬币数+1，也就是填充无法达到的最大值
        Arrays.fill(store,amount+1);
        //第一种情况是没有匹配的硬币数
        store[0]=0;
        //目标金额从1块算起，这样的目的是，举例
        //1,2,3  7
        //i=1,store[1]的最少次数为=1
        //i=2,store[2]的最少次数为store[2-2]+1=1,store[2-1]+1=2,最少次数为2
        //i=3,store[3]的最少次数为store[3-3]+1=1,store[3-2]+1=2,store[3-1]+1=3,最少次数1
        //i=4,store[4],store[4-3]+1=2,store[4-2]+1=3，store[4-1]+1=2,最少次数2
        //i=5,store[5],store[5-3]+1=3,store[5-2]+1=2，store[5-1]+1=3=>2
        //i=6,store[6],store[6-3]+1=2,store[6-2]+1=3，store[6-1]+1=3=>2
        //i=7,store[7],store[7-3]+1=3,store[7-2]+1=3，store[7-1]+1=3=>2
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    //当前值比目标值小时,则（目标值-当前值）对应的store的值+1后的值则为可能的store[i]的最小值，需要进行比较
                    store[i]=Math.min(store[i],store[i-coins[j]]+1);
                }
            }
        }
        return store[amount]>amount?-1:store[amount];
    }

    public static void main(String[] args) {
        int i = new A322_ChangeExchange().coinChange(new int[]{1, 2, 3}, 7);
        System.out.println(i);
    }

}
