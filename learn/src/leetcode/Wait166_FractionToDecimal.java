//package leetcode;
//
///**
// * 166. 分数到小数
// * @author: wyj
// * @date: 2021/07/14
// */
//public class Wait166_FractionToDecimal {
//    /**
//     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
//     *  如果小数部分为循环小数，则将循环的部分括在括号内。
//     *  如果存在多个答案，只需返回 任意一个 。
//     *  对于所有给定的输入，保证 答案字符串的长度小于 104 。
//     *  示例 1：
//     * 输入：numerator = 1, denominator = 2
//     * 输出："0.5"
//     *  示例 2：
//     * 输入：numerator = 2, denominator = 1
//     * 输出："2"
//     *  示例 3：
//     * 输入：numerator = 2, denominator = 3
//     * 输出："0.(6)"
//     *  示例 4：
//     * 输入：numerator = 4, denominator = 333
//     * 输出："0.(012)"
//     *  示例 5：
//     * 输入：numerator = 1, denominator = 5
//     * 输出："0.2"
//     */
//    public String fractionToDecimal(int numerator, int denominator) {
//        //不清楚是不是直接除就可以了
//        double v = numerator / 1.0 / denominator;
//        //检查循环数
//        String s = Double.toString(v);
//
//        return s;
//    }
//
//    public static void main(String[] args) {
//        String s = new Wait166_FractionToDecimal().fractionToDecimal(2, 3);
//        System.out.println(s);
//    }
//}