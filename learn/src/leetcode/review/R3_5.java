package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R3_5 {
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    /**
     * 			执行耗时:21 ms,击败了18.05% 的Java用户
     * 			内存消耗:38.5 MB,击败了64.51% 的Java用户
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Deque<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (path.contains(c)){
                path.pollFirst();
            }
            path.offerLast(c);
            max=Math.max(path.size(),max);
        }
        return max;
    }
}
