package leetcode.review;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R3_3 {
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        Queue<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(path.contains(c)){
                while (path.contains(c)){
                    path.poll();
                }
                path.offer(c);
            }else{
                path.offer(c);
                max=Math.max(max,path.size());
            }
        }
        return max;
    }
}
