package leetcode;

/**
 * 29.两数相除
 * @author: wyj
 * @date: 2021/04/22
 */
public class A29_DivisionOfTwoNumbers {
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
        int divide = new A29_DivisionOfTwoNumbers().divide(-2147483648, -1);
        System.out.println(divide);
//        System.out.println("2147483648");
    }
    /**
     * 举例：11 除以 3 。
     * 11比3大，结果至少是1，然后让3翻倍，为6。
     * 11大于6，6继续翻倍，为12，11比12小，结果至少为2，11-6=5
     * 5是否比3大，是为1，然后让3翻倍，为6，6比5大结果减一为1
     * 因此11/3输出2+1=3
     * 注意：这里面超出int范围的坑太多了，越早把int转换为long越好，可以避免很多int的麻烦
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35.3 MB,击败了97.80% 的Java用户
     *
     */
    public int divide(int dividend, int divisor) {
        int symbol=1;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            symbol=-1;
        }
        //通过long类型a、b接收避免很多int的麻烦
        long a=dividend;
        long b=divisor;
        a=a<0?-a:a;
        b=b<0?-b:b;
        long r= mul(a,b);
        if(symbol<0){
            //不能小于最小值，小于最小值返回最小值
            if(-r<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                r=-r;
            }
        }else{
            //不能大于最大值，大于最大值返回最大值
            if(r>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int)r;
    }

    private long mul(long a, long b) {
        //11/3
        if(a<b){
            return 0;
        }
        //使用long是为了防止int值乘2后超出int最大值
        //3
        long tmp=b;
        //1
        long count=1;
        while ((tmp+tmp)<=a){
            tmp=tmp+tmp;
            count=count+count;
            //第一次
            //6
            //2
            //第二次退出循环
        }
        //11-6=5
        long i = a - tmp;
        //5/3=1
        long mul = mul(i, b);
        //2+1=3
        return count+mul;
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
