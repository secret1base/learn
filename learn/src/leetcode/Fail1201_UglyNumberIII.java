//package leetcode;
//
///**
// * 1201. 丑数 III
// * @author: wyj
// * @date: 2021/07/28
// */
//public class Fail1201_UglyNumberIII {
//    /**
//     * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
//     *  丑数是可以被 a 或 b 或 c 整除的 正整数 。
//     *  示例 1：
//     * 输入：n = 3, a = 2, b = 3, c = 5
//     * 输出：4
//     * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
//     *  示例 2：
//     * 输入：n = 4, a = 2, b = 3, c = 4
//     * 输出：6
//     * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
//     *  示例 3：
//     * 输入：n = 5, a = 2, b = 11, c = 13
//     * 输出：10
//     * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
//     *  示例 4：
//     * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
//     * 输出：1999999984
//     *  提示：
//     *  1 <= n, a, b, c <= 10^9
//     *  1 <= a * b * c <= 10^18
//     *  本题结果在 [1, 2 * 10^9] 的范围内
//     */
//    /**
//     * 超时了
//     */
//    public int nthUglyNumber(int n, int a, int b, int c) {
//        int[] arr=new int[n];
//        int x=1;
//        int y=1;
//        int z=1;
//        for (int i = 0; i < n; i++) {
//            int min = Math.min(Math.min(a * x, b * y), c * z);
//            if(min==a*x){
//                x++;
//            }else if(min==b*y){
//                y++;
//            }else if(min==c*z){
//                z++;
//            }
//            //检查是否和相关数相等，相等则本次不算
//            if(i>0&&arr[i-1]==min){
//                i--;
//                continue;
//            }
//            arr[i]=min;
//        }
//        return arr[n-1];
//    }
//
//    public static void main(String[] args) {
//        int i = new Fail1201_UglyNumberIII().nthUglyNumber(4, 2, 3, 4);
//        System.out.println(i);
//    }
//}
