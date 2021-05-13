package leetcode;

/**
 * 43.字符串相乘
 * @author: wyj
 * @date: 2021/05/13
 */
public class A43_StringMultiply {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *  示例 1:
     *  输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *  示例 2:
     *  输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *  说明：
     *  num1 和 num2 的长度小于110。
     *  num1 和 num2 只包含数字 0-9。
     *  num1 和 num2 均不以零开头，除非是数字 0 本身。
     *  不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public static void main(String[] args) {
        String multiply = new A43_StringMultiply().multiply("123", "456");
//        String multiply = new A43_StringMultiply().multiply("9", "9");
//        String multiply = new A43_StringMultiply().multiply("9", "99");
//        String multiply = new A43_StringMultiply().multiply("2", "3");
        System.out.println(multiply);
    }

    /**
     * 输入”123“，”456“,解题过程如下
     * 			123
     * 			456
     * ------------------
     * 			738
     * 		   6150
     * 		  49200
     * ------------------
     * 		  56088
     * 738+6150,是先 8+0=8 => 3+5=8 => 7+1=8 =>6 ,组合成8886，然后反转字符串为6888即为结果
     * 		  	执行耗时:33 ms,击败了12.38% 的Java用户
     * 			内存消耗:38.8 MB,击败了35.34% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String sum=new String("0");
        for (int x=num1.length()-1;x>=0;x--){
            StringBuilder tmp=new StringBuilder();
            for (int i = 0; i < num1.length()-1-x; i++){
                tmp.append(0);
            }
            int carry=0;
            int a=num1.charAt(x)-'0';
            for(int y=num2.length() - 1; y >= 0; y--){
                int b = num2.charAt(y) - '0';
                int i = a * b + carry;
                carry = i / 10;
                tmp.append(i%10);
                //下一次循环需要加的值，如 3*7=21，下一位需要加2，当前为保留1,21/10=2,21%10 =1
            }
            if(carry>0){
                tmp.append(carry);
            }
            tmp.reverse();
//            System.out.println(tmp.toString());
            sum = addString(sum,tmp);
        }
        return sum;
    }

    private String addString(String sum, StringBuilder tmp) {
        int x=sum.length() - 1;
        int y=tmp.length()-1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while (x>=0||y>=0){
            int i=x<0?0:sum.charAt(x) - '0';
            int i1=y<0?0:tmp.charAt(y) - '0';
            s.append((i+i1+carry)%10);
            carry=(i+i1+carry)/10;
            y--;
            x--;
        }
        if(carry!=0){
            s.append(carry);
        }
        return s.reverse().toString();
    }

}
