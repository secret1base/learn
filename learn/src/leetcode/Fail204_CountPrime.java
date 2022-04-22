//package leetcode;
//
///**
// * 204. 计数质数
// * @author: wyj
// * @date: 2021/07/28
// */
//public class Fail204_CountPrime {
//    /**
//     * 统计所有小于非负整数 n 的质数的数量。
//     *  示例 1：
//     *  输入：n = 10
//     * 输出：4
//     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//     *  示例 2：
//     *  输入：n = 0
//     * 输出：0
//     *  示例 3：
//     *  输入：n = 1
//     * 输出：0
//     *  提示：
//     *  0 <= n <= 5 * 106
//     */
//    /**
//     * 超时
//     * @param n
//     * @return
//     */
//    public int countPrimes(int n) {
//        //质数只能被1和本身整除
//        int count=0;
//        for (int i = 2; i < n; i++) {
//            boolean success=false;
//            for (int j = 2; j < i; j++) {
//                if(i%j==0){
//                    success=true;
//                    break;
//                }
//            }
//            if(!success){
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int i = new Fail204_CountPrime().countPrimes(10);
//        System.out.println(i);
//    }
//}
