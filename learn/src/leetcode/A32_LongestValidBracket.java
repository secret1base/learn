package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 32. 最长有效括号
 * @author: wyj
 * @date: 2021/04/20
 */
public class A32_LongestValidBracket {
    /**
     * 32. 最长有效括号
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 示例 1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * 输入：s = ""
     * 输出：0
     * 提示：
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     */
    public static void main(String[] args) {
//        int i = new A32_LongestValidBracket().longestValidParentheses("()()");
        int i = new A32_LongestValidBracket().longestValidParentheses("()()((()))())))(((())))(()(())()((()(((((())(()(()))(()(()()))))))(((((()))))()(())())))()))(()())()(()))((())()(()()())(()((((()())()())((((()(()())())((()(()))())))))())())((");
        System.out.println(i);//76
    }

    /**
     * 第二次解题
     * 执行用时：2 ms, 在所有 Java 提交中击败了69.75%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了65.16%的用户
     */
    public int longestValidParentheses(String s) {
        int max=0;
        int length = s.length();
        int left=0;
        int right=0;
        //每出现一个左括号就需要一个右括号进行抵消，如果右括号个数大于左括号就清零重新计数
        for(int i = 0; i < length; i++){
            if('('==s.charAt(i)){
                left++;
            }else{
                right++;
            }
            if(left ==right){
                max= max>right*2?max:right * 2;
            }else if(right>left){
                left=0;
                right=0;
            }
        }
        right=0;
        left=0;
        //反方向检查
        for(int i = length-1; i >= 0; i--){
            if(')'==s.charAt(i)){
                right++;
            }else{
                left++;
            }
            if(left ==right){
                max= max>right*2?max:right * 2;
            }else if(left>right){
                left=0;
                right=0;
            }
        }
        return max;
    }





//【
//    /**
//     * 第一次解题：思路应该没错但是超时了,通过遍历替换的方式找到有效括号
//     * @param s
//     * @return
//     */
//    public int longestValidParentheses(String s) {
//        int max=0;
//        int length = s.length();
//        for(int i = 0; i < length; i++){
//            for (int j = i+1; j <= length; j++) {
//                String substring = s.substring(i, j);
//                if(validate(substring)){
//                    max=substring.length()>max?substring.length():max;
//                }
//            }
//        }
//        return max;
//    }
//
//    public boolean validate(String s){
//        while (s.length() > 0) {
//            int length = s.length();
//            s=s.replaceAll("\\(\\)","").replaceAll("\\{\\}","").replaceAll("\\[\\]","");
//            if(length==s.length()){
//                break;
//            }
//        }
//        return s.length()==0;
//    }
//】
}
