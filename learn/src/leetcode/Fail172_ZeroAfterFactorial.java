//package leetcode;
//
///**
// * 172. 阶乘后的零
// * @author: wyj
// * @date: 2021/07/09
// */
//public class Fail172_ZeroAfterFactorial {
//    /**
//     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
//     *  示例 1:
//     *  输入: 3
//     * 输出: 0
//     * 解释: 3! = 6, 尾数中没有零。
//     *  示例 2:
//     *  输入: 5
//     * 输出: 1
//     * 解释: 5! = 120, 尾数中有 1 个零.
//     */
//    /**
//     * 暴力破解
//     * @param n
//     * @return
//     */
//    public int trailingZeroes(int n) {
//        long sum=1;
//        for (int i = 1; i <= n; i++) {
//            sum*=i;
//        }
//        String s = Long.toString(sum);
//        //检查0
//        int count=0;
//        for (int i = s.length()-1; i >=0;i-- ){
//            char c = s.charAt(i);
//            if(c=='0'){
//                count++;
//            }else{
//                break;
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int i = new Fail172_ZeroAfterFactorial().trailingZeroes(13);
//        System.out.println(i);
//    }
////    /**
////     * 先看下有没有规律
////     * @param args
////     */
////    public static void main(String[] args) {
////        int sum=1;
////        for (int i=1;i<10;i++){
////            sum*=i;
////            System.out.println(sum);
////        }
////        /**
////         * 1
////         * 2
////         * 6
////         * 24
////         * 120
////         * 720
////         * 5040
////         * 40320
////         * 362880
////         */
////    }
//}
