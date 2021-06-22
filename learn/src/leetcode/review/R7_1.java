package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/16
 */
public class R7_1 {
    /**
     * 			执行耗时:4 ms,击败了11.32% 的Java用户
     * 			内存消耗:35.9 MB,击败了9.42% 的Java用户
     */
    public int reverse(int x) {
        String s = Integer.toString(x);
        String pre="";
        if(s.charAt(0)=='-'){
            pre="-";
            s=s.substring(1);
        }
        StringBuilder b=new StringBuilder(s);
        String n = b.reverse().toString();
        try {
            return Integer.parseInt(pre+n);
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new R7_1().reverse(-123));
    }
}
