package leetcode.review;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R3_2 {
    /**
     * 		执行耗时:23 ms,击败了17.38% 的Java用户
     * 		内存消耗:38.4 MB,击败了86.11% 的Java用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> path=new LinkedList<>();
        int max=0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!path.contains(c)){
                path.offer(c);
                max=Math.max(path.size(),max);
            }else{
                while (path.contains(c)) {
                    path.poll();
                }
                path.offer(c);
            }
        }
        return max;
    }
}
