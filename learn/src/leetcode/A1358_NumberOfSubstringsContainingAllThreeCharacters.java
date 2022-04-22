package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1358. 包含所有三种字符的子字符串数目
 * @author: wyj
 * @date: 2021/08/30
 */
public class A1358_NumberOfSubstringsContainingAllThreeCharacters {
    /**
     * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
     *  请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
     *  示例 1：
     *  输入：s = "abcabc"
     * 输出：10
     * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bc
     * abc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
     *  示例 2：
     *  输入：s = "aaacb"
     * 输出：3
     * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
     *  示例 3：
     *  输入：s = "abc"
     * 输出：1
     *  提示：
     *  3 <= s.length <= 5 x 10^4
     *  s 只包含字符 a，b 和 c 。
     *  Related Topics 哈希表 字符串 滑动窗口
     */
    /**
     * 第二版：在第一版的基础上优化后的
     * 			执行耗时:42 ms,击败了11.11% 的Java用户
     * 			内存消耗:39.5 MB,击败了5.31% 的Java用户
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        int count=0;
        Map<Character,Integer> map=new HashMap<>();
        Deque<Character> path=new LinkedList<>();
        int right=0;
        while (true) {
            while (map.values().size() < 3 && right < s.length()) {
                char c = s.charAt(right++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                path.offerLast(c);
            }
            if (map.values().size() == 3) {
                count++;
                //剩余次数
                int add = s.length() - right;
                count += add;
            }
            Character character = path.pollFirst();
            Integer orDefault = map.getOrDefault(character, 0);
            if (orDefault == 1) {
                map.remove(character);
            }else{
                map.put(character,orDefault-1);
            }
            if(right==s.length()&&map.values().size() < 3){
                break;
            }
        }
        return count;
    }
//    /**
//     * 第一版：超时
//     * @param s
//     * @return
//     */
//    public int numberOfSubstrings(String s) {
//        int count=0;
//        Map<Character,Integer> map=new HashMap<>();
//        for (int left = 0; left < s.length(); left++) {
//            int i=left;
//            while (map.values().size()<3&&i<s.length()){
//                char c = s.charAt(i++);
//                map.put(c,map.getOrDefault(c,0)+1);
//            }
//            if(map.values().size()==3){
//                count++;
//                //剩余次数
//                int add = s.length() - i;
//                count+=add;
//            }
//            map=new HashMap<>();
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int abcabc = new A1358_NumberOfSubstringsContainingAllThreeCharacters().numberOfSubstrings("aaacb");
        System.out.println(abcabc);
    }

}
