package leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R3_4 {
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    /**
     * 		执行耗时:23 ms,击败了17.46% 的Java用户
     * 		内存消耗:38.3 MB,击败了87.38% 的Java用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> path=new LinkedList<>();
        int max=0;
        for (int left = 0; left < s.length(); left++) {
            while (path.contains(s.charAt(left))){
                path.pollFirst();
            }
            path.offerLast(s.charAt(left));
            max=Math.max(max,path.size());
        }
        return max;
    }
}
