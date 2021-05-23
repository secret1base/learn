package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R415_4 {
    public String addStrings(String num1,String num2){
        int x = num1.length() - 1;
        int y = num2.length() - 1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while (x>=0||y>=0||carry!=0){
            int a=x<0?0:num1.charAt(x)-'0';
            int b=y<0?0:num2.charAt(y)-'0';
            int i = a + b + carry;
            s.append(i%10);
            carry=i/10;
            y--;
            x--;
        }
        return s.reverse().toString();
    }
}
