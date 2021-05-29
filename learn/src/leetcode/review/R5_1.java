package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/27
 */
public class R5_1 {
//给你一个字符串 s，找到 s 中最长的回文子串。
// 示例 1：
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 示例 2：
//输入：s = "cbbd"
//输出："bb"
// 示例 3：
//输入：s = "a"
//输出："a"
// 示例 4：
//输入：s = "ac"
//输出："a"
// 提示：
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
public static void main(String[] args) {
    String cbbd = new R5_1().longestPalindrome("ccc");
    System.out.println(cbbd);
}

    /**
     * 			执行耗时:39 ms,击败了73.59% 的Java用户
     * 			内存消耗:39.1 MB,击败了52.29% 的Java用户
     */
    String max=null;
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        max=s.substring(0,1);
        for (int i=0;i<s.length();i++){
            //向两边找
            getMaxString(s,i, i+1);
            getMaxString(s,i-1, i+1);
        }
        return max;
    }

    private void getMaxString(String s, int left, int right) {
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                if(right-left+1>max.length()){
                    max=s.substring(left, right+1);
                }
                left--;
                right++;
            }else{
                break;
            }
        }
    }


}
