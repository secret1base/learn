package leetcode;

/**
 * 69.x 的平方根
 * @author: wyj
 * @date: 2021/05/19
 */
public class A69_TheSquareRootOfX {
    /**
     * 实现 int sqrt(int x) 函数。
     *  计算并返回 x 的平方根，其中 x 是非负整数。
     *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *  示例 1:
     *  输入: 4
     * 输出: 2
     *  示例 2:
     *  输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */
    public static void main(String[] args) {
        int i = new A69_TheSquareRootOfX().mySqrt(10);
    }
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int res=0;
        while (left<=right){
//            System.out.println("left="+left+",right="+right);
            int mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                res=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return res;
    }
}
