package leetcode;

/**
 * 剑指 Offer 10- I斐波那契数列
 * @author: wyj
 * @date: 2021/06/14
 */
public class A10010_FibonacciNumber {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.1 MB,击败了73.13% 的Java用户
     */
    public int fib(int n) {
        int[] store=new int[n<1?2:n+1];
        store[0]=0;
        store[1]=1;
        for (int i = 2; i < n+1; i++){
            store[i]=(store[i-1]+store[i-2])%1000000007;
        }
        return store[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(new A10010_FibonacciNumber().fib(i));
        }
    }
}
