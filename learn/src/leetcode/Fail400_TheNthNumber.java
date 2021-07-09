package leetcode;

/**
 * 400. 第N个数字
 * @author: wyj
 * @date: 2021/07/09
 */
public class Fail400_TheNthNumber {
    /**
     * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
     *  注意：n 是正数且在 32 位整数范围内（n < 231）。
     *  示例 1：
     * 输入：3
     * 输出：3
     *  示例 2：
     * 输入：11
     * 输出：0
     * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
     *
     * 暴力破解，超时
     */
    public int findNthDigit(int n) {
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        return sb.toString().charAt(n-1)-'0';
    }

    public static void main(String[] args) {
        int nthDigit = new Fail400_TheNthNumber().findNthDigit(3);
        System.out.println(nthDigit);
    }
}
