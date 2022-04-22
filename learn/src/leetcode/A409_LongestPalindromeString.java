package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 * @author: wyj
 * @date: 2021/07/26
 */
public class A409_LongestPalindromeString {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *  在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *  注意:
     * 假设字符串的长度不会超过 1010。
     *  示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * 			执行耗时:8 ms,击败了30.99% 的Java用户
     * 			内存消耗:36.7 MB,击败了54.82% 的Java用户
     */
    public int longestPalindrome(String s) {
        //计算成对数量
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c,count+1);
        }
        int pair=0;
        int single=0;
        for (Integer value : map.values()) {
            pair+=value/2;
            if(value%2!=0){
                single=1;
            }
        }
        return pair*2+single;
    }
}
