package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 518.零钱兑换 II
 * @author: wyj
 * @date: 2021/06/22
 */
public class A518_ChangeII {
    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     *  请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     *  假设每一种面额的硬币有无限个。
     *  题目数据保证结果符合 32 位带符号整数。
     *  示例 1：
     * 输入：amount = 5, coins = [1, 2, 5]
     * 输出：4
     * 解释：有四种方式可以凑成总金额：
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *  示例 2：
     * 输入：amount = 3, coins = [2]
     * 输出：0
     * 解释：只用面额 2 的硬币不能凑成总金额 3 。
     *  示例 3：
     * 输入：amount = 10, coins = [10]
     * 输出：1
     *
     *
     */
    /**
     * 动态规划：并没有理解下面的解题方式
     * 			执行耗时:2 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.9 MB,击败了60.70% 的Java用户
     */
    public int change(int amount, int[] coins) {
        int[] store=new int[amount+1];
        store[0]=1;
        for (int coin : coins) {
            for (int i=coin;i<=amount;i++){
                store[i]+=store[i-coin];
            }
        }
        return store[amount];
    }
//    /**
//     * 回溯算法超时
//     */
//    int count=0;
//    public int change(int amount, int[] coins) {
//        if(amount==0){
//            return 1;
//        }
//        for (int i = 0; i < coins.length; i++) {
//            int coin = coins[i];
//            record(i,coin,amount,coins);
//        }
//        return count;
//    }
//
//    private void record(int index, int sum, int amount, int[] coins) {
//        if(sum==amount){
//            count++;
//            return;
//        }else if(sum>amount){
//            return;
//        }
//        for (int i = index; i < coins.length; i++) {
//            int coin = coins[i];
//            record(i,sum+coin,amount,coins);
//        }
//    }

    public static void main(String[] args) {
        int change = new A518_ChangeII().change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
