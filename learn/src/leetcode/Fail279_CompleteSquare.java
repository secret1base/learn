//package leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 279. 完全平方数
// * @author: wyj
// * @date: 2021/07/23
// */
//public class Fail279_CompleteSquare {
//    /**
//     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//     *  给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
//     *  完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//     *  示例 1：
//     * 输入：n = 12
//     * 输出：3
//     * 解释：12 = 4 + 4 + 4
//     *  示例 2：
//     * 输入：n = 13
//     * 输出：2
//     * 解释：13 = 4 + 9
//     *  提示：
//     *  1 <= n <= 104
//     */
//    public int numSquares(int n) {
//        List<Integer> squares=new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            squares.add(i*i);
//        }
//        int index=squares.size()-1;
//        int count=0;
//        while (n!=0){
//            Integer integer = squares.get(index);
//            if(integer>n){
//                index--;
//            }else{
//                count++;
//                n-=integer;
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int i = new Fail279_CompleteSquare().numSquares(12);
//        System.out.println(i);
//    }
//}
