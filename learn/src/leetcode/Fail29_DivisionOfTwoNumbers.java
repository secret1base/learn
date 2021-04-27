package leetcode;

/**
 * 29.两数相除
 * @author: wyj
 * @date: 2021/04/22
 */
public class Fail29_DivisionOfTwoNumbers {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *  返回被除数 dividend 除以除数 divisor 得到的商。
     *  整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *  示例 1:
     *  输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     *  示例 2:
     *  输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *  提示：
     *  被除数和除数均为 32 位有符号整数。
     *  除数不为 0。
     *  假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     */
    public static void main(String[] args) {
//        int divide = new A29_DivisionOfTwoNumbers().divide(7, -3);
        int divide = new Fail29_DivisionOfTwoNumbers().divide(-2147483648, 1);
        System.out.println(divide);
//        System.out.println("2147483648");
    }
    /**
     * 解题思路是通过减法
     */
    public int divide(int dividend, int divisor) {
        int i=0;
        int symbol=1;
        int dtwo=0;
        if(dividend==Integer.MIN_VALUE){
            dividend=Integer.MAX_VALUE;
            symbol=-symbol;
            dtwo=1;
        }
        if(dividend<0){
            symbol=-symbol;
            //存在个问题--2147483648=-2147483648
            dividend=-dividend;
        }
        if(divisor<0){
            symbol = -symbol;
            divisor=-divisor;
        }
        while (dividend>=divisor){
            dividend-=divisor;
            if(i==Integer.MAX_VALUE&&symbol>0){
                return Integer.MAX_VALUE;
            }
            if(i == -Integer.MAX_VALUE && symbol < 0&&dtwo == 1){
                return Integer.MIN_VALUE;
            }
            i+=symbol;
        }
        return i;
    }



//    /**
//     * 耍无赖的解答，不符合题目要求
//     * 执行耗时:1 ms,击败了100.00% 的Java用户
//     * 	内存消耗:35.6 MB,击败了56.19% 的Java用户
//     */
//    public int divide(int dividend, int divisor) {
//        if(dividend==Integer.MIN_VALUE&&divisor==-1){
//            return Integer.MAX_VALUE;
//        }
//        int i = dividend / divisor;
//        return i;
//    }
}
