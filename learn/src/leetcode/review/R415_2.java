package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/16
 */
public class R415_2 {
    public static void main(String[] args) {
        String s = new R415_2().addStrings("12", "123");
        System.out.println(s);
    }

    /**
     * 			执行耗时:2 ms,击败了99.76% 的Java用户
     * 			内存消耗:38.1 MB,击败了95.58% 的Java用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1,String num2){
        int x=num1.length()-1;
        int y=num2.length()-1;
        int carry=0;
        StringBuilder s=new StringBuilder();
        while (x>=0||y>=0||carry > 0){
            int a=x<0?0:num1.charAt(x)-'0';
            int b=y<0?0:num2.charAt(y)-'0';
            int i = a + b + carry;
            carry= i/10;
            s.append(i%10);
            x--;
            y--;
        }
        return s.reverse().toString();
    }
}
