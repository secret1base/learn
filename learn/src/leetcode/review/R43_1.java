package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/15
 */
public class R43_1 {
    /**
     * 		执行耗时:22 ms,击败了31.31% 的Java用户
     * 		内存消耗:38.8 MB,击败了33.43% 的Java用户
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        String sum=null;
        for (int i = 0; i < num2.length(); i++) {
            int c = num2.charAt(num2.length() - i - 1)-'0';
            StringBuilder s=new StringBuilder();
            for (int j = 0; j <i; j++) {
                s.append("0");
            }
            int carry=0;
            int x=num1.length()-1;
            while (x>=0||carry!=0){
                int a=x>=0?num1.charAt(x)-'0':0;
                int tmp = a * c + carry;
                s.append(tmp%10);
                carry=tmp/10;
                x--;
            }
            if(sum==null){
                sum=s.reverse().toString();
            }else{
                sum= addStr(sum,s.reverse().toString());
            }
        }
        if(sum.length()>1&&sum.charAt(0)=='0'){
            return "0";
        }
        return sum;
    }

    private String addStr(String num1, String num2) {
        int x=num1.length()-1;
        int y=num2.length()-1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while (x>=0||y>=0||carry!=0){
            int a=x>=0?num1.charAt(x)-'0':0;
            int b=y>=0?num2.charAt(y)-'0':0;
            int i = a + b + carry;
            s.append(i%10);
            carry=i/10;
            x--;
            y--;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        String multiply = new R43_1().multiply("123", "456");
        System.out.println(multiply);
    }
}
