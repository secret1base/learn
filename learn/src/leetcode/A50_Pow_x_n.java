package leetcode;

/**
 * 50.Pow(x, n)
 * @author: wyj
 * @date: 2021/06/23
 */
public class A50_Pow_x_n {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     *  示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     *  示例 2：
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     *  示例 3：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     * 			执行耗时:1 ms,击败了98.78% 的Java用户
     * 			内存消耗:37.5 MB,击败了66.35% 的Java用户
     */
    public double myPow(double x, int n) {
        return n<0?1/getSum(x,-n):getSum(x,n);
    }

    private double getSum(double x, int n) {
        if(n==0){
            return 1;
        }
        double y = getSum(x, n / 2);
        return n%2==0?y*y:y*y*x;
    }


//    /**
//     * 超时
//     * @param x
//     * @param n
//     * @return
//     */
//    public double myPow(double x, int n) {
//        boolean flag=true;
//        if(n<0){
//            n=-n;
//            flag=false;
//        }
//        double sum=1;
//        for (int i = 1; i <= n; i++) {
//            sum*=x;
//        }
//        if(!flag){
//            return 1/sum;
//        }else{
//            return sum;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new A50_Pow_x_n().myPow(2,10));
        System.out.println(new A50_Pow_x_n().myPow(2,-2));
        System.out.println(new A50_Pow_x_n().myPow(2,0));
        System.out.println(new A50_Pow_x_n().myPow(0.00001,2147483647));
    }
}
