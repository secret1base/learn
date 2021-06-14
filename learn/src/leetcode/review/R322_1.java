package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R322_1 {
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
    public int coinChange(int[] coins, int amount) {
        int[] store=new int[amount+1];
        Arrays.fill(store,amount+1);
        store[0]=0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i){
                    store[i]=Math.min(store[i],store[i-coins[j]]+1);
                }
            }
        }
        return store[amount]>amount?-1:store[amount];
    }
}
