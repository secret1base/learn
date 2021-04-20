package leetcode;

/**
 * 5. 最长回文子串
 * @author: wyj
 * @date: 2021/04/20
 */
public class A5_LongestPalindromicSubstring {
    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     */
    public static void main(String[] args) {
        String babad = new A5_LongestPalindromicSubstring().longestPalindrome("ccc");
        System.out.println(babad);
    }

    /**
     * 需要注意有两种情况:aba和aa需要分别根据这两种情况去寻找最大值
     * 另外还需要注意如果一次也没找到的话，就不会进入循环如""\"a"\"ab"都不会进入while循环，
     * 因此需要在最后一步额外进行判断下
     * 执行用时：53 ms, 在所有 Java 提交中击败了66.38%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了95.19%的用户
     */
    public String longestPalindrome(String s) {
        //两种情况：中间节点为aba和bb
        int length = s.length();
        String str="";
        for (int i = 0; i < length; i++){
            int left=i-1;
            int right=i+1;
            while (left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>str.length()){
                    str=s.substring(left,right+1);
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while (left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                if(right-left+1>str.length()){
                    str=s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        if(str.length()==0){
            //可能s为""，也可能为"a"\"ac"这种情况
            if(s.length()==0){
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        return str;
    }


}
