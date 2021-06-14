package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R5_3 {
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//			执行耗时:62 ms,击败了62.94% 的Java用户
//			内存消耗:38.7 MB,击败了65.79% 的Java用户
    public String longestPalindrome(String s) {
        String max=s.substring(0,1);
        for (int i=0;i < s.length(); i++){
            int left=i-1;
            int right=i+1;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if(right-left+1>max.length()){
                        max=s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            left=i;
            right=i+1;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    if(right-left+1>max.length()){
                        max=s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String ababab = new R5_3().longestPalindrome("ababab");
        System.out.println(ababab);
    }
}
