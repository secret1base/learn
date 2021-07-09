package leetcode;

/**
 * @author: wyj
 * @date: 2021/06/29
 */
public class A509_FibonacciNumber {
    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     *  给你 n ，请计算 F(n) 。
     *  示例 1：
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     *  示例 2：
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     *  示例 3：
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:34.8 MB,击败了98.78% 的Java用户
     */
    public int fib(int n) {
        int[] arr=new int[n<2?2:n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i < n+1; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new A509_FibonacciNumber().fib(i));
        }
    }
}
