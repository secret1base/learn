package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 821. 字符的最短距离
 * @author: wyj
 * @date: 2021/07/16
 */
public class A821_MinimumDistanceOfCharacters {
    /**
     * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
     *  返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的
     * 字符 c 的 距离 。
     *  两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
     *  示例 1：
     * 输入：s = "loveleetcode", c = "e"
     * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
     * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
     * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
     * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 3 。
     * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
     * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
     *  示例 2：
     * 输入：s = "aaab", c = "b"
     * 输出：[3,2,1,0]
     * 提示：
     *  1 <= s.length <= 104
     *  s[i] 和 c 均为小写英文字母
     *  题目数据保证 c 在 s 中至少出现一次
     *
     *  	执行耗时:9 ms,击败了11.01% 的Java用户
     * 		内存消耗:39.1 MB,击败了5.21% 的Java用户
     */
    public int[] shortestToChar(String s, char c) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==c){
                map.put(i,1);
            }
        }
        int[] arr=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(i);
            if(integer!=null){
                //当前值就是目标值，距离为0
                continue;
            }
            int left=i-1;
            while (left>=0&&map.get(left)==null){
                //找到i左侧的目标值
                left--;
            }
            int right=i+1;
            while (right<s.length()&&map.get(right)==null){
                //找到i左侧的目标值
                right++;
            }
            if(left<0){
                arr[i]=right-i;
                continue;
            }
            if(right==s.length()){
                arr[i]=i-left;
                continue;
            }
            arr[i]=Math.min(right-i,i-left);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new A821_MinimumDistanceOfCharacters().shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));
    }
}
