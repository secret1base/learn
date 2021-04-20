package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 * @author: wyj
 * @date: 2021/04/20
 */
public class A3_TheLongestSubstringWithoutRepeatingCharacters {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * 输入: s = ""
     * 输出: 0
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    public static void main(String[] args) {
        int adds = new A3_TheLongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("pwwkew");
        System.out.println(adds);
    }

    /**
     * 执行用时：845 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了28.86%的用户
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max=0;
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list=new ArrayList<>();
            for (int j = i; j < length; j++) {
                if(list.contains(s.charAt(j))){
                    max=Math.max(max,list.size());
                    break;
                }else{
                    list.add(s.charAt(j));
                    //当没有下一次执行时，提前进行长度判断
                    if(j+1==length){
                        max=Math.max(max,list.size());
                    }
                }
            }
        }
        return max;
    }


}
