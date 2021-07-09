//package leetcode;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * 440. 字典序的第K小数字
// * @author: wyj
// * @date: 2021/06/29
// */
//public class Fail440_TheKSmallNumberOfDictionaryOrder {
//    /**
//     * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
//     *  注意：1 ≤ k ≤ n ≤ 109。
//     *  示例 :
//     * 输入:
//     * n: 13   k: 2
//     * 输出:
//     * 10
//     * 解释:
//     * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
//     */
//    public int findKthNumber(int n, int k) {
//
//    }
////    /**
////     * 测试用例:4289384 1922239
////     * Memory Limit Exceeded
////     * 也就是说不能这样进行解题
////     * @param n
////     * @param k
////     * @return
////     */
////    public int findKthNumber(int n, int k) {
////        List<String> list=new ArrayList<>();
////        for (int i = 0; i < n; i++) {
////            list.add(Integer.toString(i+1));
////        }
////        Collections.sort(list);
////        return Integer.parseInt(list.get(k-1));
////    }
//}
