package leetcode;

/**
 * 415.字符串相加
 * @author: wyj
 * @date: 2021/05/14
 */
public class A415_StringAddition {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *  提示：
     *  num1 和num2 的长度都小于 5100
     *  num1 和num2 都只包含数字 0-9
     *  num1 和num2 都不包含任何前导零
     *  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     */


    public static void main(String[] args) {
        String s = new A415_StringAddition().addStrings("11", "123");
        System.out.println(s);
    }


    /**
     * 			执行耗时:3 ms,击败了65.53% 的Java用户
     * 			内存消耗:38.1 MB,击败了97.33% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int x=num1.length()-1;
        int y = num2.length() - 1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while (x>=0||y>=0||carry>0){
            int a=x<0?0:num1.charAt(x)-'0';
            int b=y<0?0:num2.charAt(y)-'0';
            x--;
            y--;
            int i = a + b + carry;
            s.append(i%10);
            carry=i/10;
        }
        return s.reverse().toString();
    }
}
