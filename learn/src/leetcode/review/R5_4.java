package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R5_4 {
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。

    /**
     * 			执行耗时:48 ms,击败了66.02% 的Java用户
     * 			内存消耗:38.8 MB,击败了61.48% 的Java用户
     */
    public String longestPalindrome(String s) {
        //回文有两种aba、aa
        int max=0;
        String maxStr="";
        for (int i = 0; i <s.length();i++){
            int left=i;
            int right=i;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }else{
                    if(right-left+1>max){
                        max=right-left+1;
                        maxStr=s.substring(left,right+1);
                    }
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }else{
                    if(right-left+1>max){
                        max=right-left+1;
                        maxStr=s.substring(left,right+1);
                    }
                }
                left--;
                right++;
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        String babad = new R5_4().longestPalindrome("babad");
        System.out.println(babad);
    }
}
