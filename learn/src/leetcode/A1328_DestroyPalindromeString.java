package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1328. 破坏回文串
 * @author: wyj
 * @date: 2021/08/19
 */
public class A1328_DestroyPalindromeString {
    /**
     * 给你一个由小写英文字母组成的回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的 字典序最小 ，且 不是 回文串。
     *  请你返回结果字符串。如果无法做到，则返回一个 空串 。
     *  如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符严格小于 b 中的
     * 对应字符。例如，"abcc” 字典序比 "abcd" 小，因为不同的第一个位置是在第四个字符，显然 'c' 比 'd' 小。
     *  示例 1：
     * 输入：palindrome = "abccba"
     * 输出："aaccba"
     * 解释：存在多种方法可以使 "abccba" 不是回文，例如 "zbccba", "aaccba", 和 "abacba" 。
     * 在所有方法中，"aaccba" 的字典序最小。
     *  示例 2：
     * 输入：palindrome = "a"
     * 输出：""
     * 解释：不存在替换一个字符使 "a" 变成非回文的方法，所以返回空字符串。
     *  示例 3：
     * 输入：palindrome = "aa"
     * 输出："ab"
     *  示例 4：
     * 输入：palindrome = "aba"
     * 输出："abb"
     *  提示：
     *  1 <= palindrome.length <= 1000
     *  palindrome 只包含小写英文字母。
     *  Related Topics 贪心 字符串
     *
     * 一开始以为不好做打算暂时先不做的，没想到梳理后意外的简单
     * 			执行耗时:3 ms,击败了26.64% 的Java用户
     * 			内存消耗:36.8 MB,击败了11.21% 的Java用户
     */
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        //1、需要验证是否为回文字符串的方法
        //2、在进行替换时需要保证是最小的字典序，那么对字母进行替换时先从前向后替换，
        // 替换时注意必须用比当前字母字典序小的数，如果没有替换成功，再从后向前进行替换，用比当前字母字典序大的数
        List<String> dictList=new ArrayList<>();
        dictList.add("a");
        dictList.add("b");
        dictList.add("c");
        dictList.add("d");
        dictList.add("e");
        dictList.add("f");
        dictList.add("g");
        dictList.add("h");
        dictList.add("i");
        dictList.add("j");
        dictList.add("k");
        dictList.add("l");
        dictList.add("m");
        dictList.add("n");
        dictList.add("o");
        dictList.add("p");
        dictList.add("q");
        dictList.add("r");
        dictList.add("s");
        dictList.add("t");
        dictList.add("u");
        dictList.add("v");
        dictList.add("w");
        dictList.add("x");
        dictList.add("y");
        dictList.add("z");
        //从前往后替换成功标识
        for (int i = 0; i < palindrome.length();i++){
            String c = palindrome.charAt(i)+"";
            for (String s : dictList) {
                //替换必须s比c小
                if(s.compareTo(c)>=0){
                    break;
                }else{
                    StringBuilder sb=new StringBuilder(palindrome);
                    sb.replace(i,i+1,s);
                    //必须不为回文
                    if(!validate(sb.toString())){
                        return sb.toString();
                    }
                }
            }
        }
        //从前往后替换小的没有成功，则从后向前替换大的
        //从后往前
        for (int i = palindrome.length()-1; i >=0;i--){
            String c = palindrome.charAt(i)+"";
            for (String s : dictList) {
                //替换必须s比c大,大一点就可以，所以还是升序
                if(s.compareTo(c)<=0){
                    continue;
                }else{
                    StringBuilder sb=new StringBuilder(palindrome);
                    sb.replace(i,i+1,s);
                    //必须不为回文
                    if(!validate(sb.toString())){
                        return sb.toString();
                    }
                }
            }
        }
        return "";
    }


    /**
     * 验证是否为回文
     * @param str
     * @return
     */
    private boolean validate(String str){
        int mid = str.length() / 2;//0 1 2 3    0 1 2 3 4
        if(str.length()%2==0){
            int left=mid-1;
            int right=mid;
            while (left>=0&&right<str.length()){
                if(str.charAt(left)!=str.charAt(right)){
                    return false;
                }else{
                    left--;
                    right++;
                }
            }
        }else{
            int left=mid-1;
            int right=mid+1;
            while (left>=0&&right<str.length()){
                if(str.charAt(left)!=str.charAt(right)){
                    return false;
                }else{
                    left--;
                    right++;
                }
            }
        }
        return true;
    }
}
