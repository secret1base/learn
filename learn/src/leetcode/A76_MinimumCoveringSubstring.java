package leetcode;

import java.util.*;

/**
 * 76. 最小覆盖子串
 * @author: wyj
 * @date: 2021/06/10
 */
public class A76_MinimumCoveringSubstring {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *  注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *  示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     *  示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     *  提示：
     *  1 <= s.length, t.length <= 105
     *  s 和 t 由英文字母组成
     * @param s
     * @param t
     * @return
     */
    /**
     * 注："AAB" "AA" 的输出为"AA"而不是"A"
     */
    //			执行耗时:128 ms,击败了13.52% 的Java用户
    //			内存消耗:39.3 MB,击败了28.35% 的Java用户
    Map<Character,Integer> aMap=new HashMap<>();
    Map<Character,Integer> bMap=new HashMap<>();

    /**
     * 双指针，右指针每次向右边移动一位(对应数字+1)，一直到满足要求后，更新最小值，
     * 左指针开始向右移动(对应数字-1)，一直到不满足要求，在不满足要求前一直会更新最小值
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        //双指针+检查+判断长度+map出一个数，减一，进一个数+1
        String minStr="";
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            Integer count = bMap.getOrDefault(c, 0);
            bMap.put(c,count+1);
        }
        int left=-1;
        int right=-1;
        int min=Integer.MAX_VALUE;
        while (right<s.length()-1){
            ++right;
            char r = s.charAt(right);
            //右边进一
            Integer c = aMap.getOrDefault(r, 0);
            aMap.put(r,c+1);
            while (left<right&&check()){
                if(right-left<min){
                    minStr=s.substring(left+1,right+1);
                    min=right-left;
                }
                ++left;
                char l = s.charAt(left);
                aMap.put(l,aMap.getOrDefault(l, 0)-1);
            }
        }
        return minStr;
    }

    private boolean check() {
        for (Character s : bMap.keySet()) {
            if(aMap.getOrDefault(s,0)<bMap.get(s)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new A76_MinimumCoveringSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }



    //超时
//    public String minWindow(String s, String t) {
//        String max="";
//        String[] arr = t.split("");
//        Map<String,Integer> map=new HashMap<>();
//        for (String s1 : arr) {
//            Integer count = map.getOrDefault(s1, 0);
//            map.put(s1,count+1);
//        }
//        for (int left=0;left<s.length();left++){
//            for (int right = left+arr.length; right <= s.length(); right++) {
//                String substring = s.substring(left, right);
//                if(check(substring,map)){
//                    if(max==""||max.length()>substring.length()){
//                        max=substring;
//                    }
//                }
//            }
//        }
//        //双指针+检查+判断长度
//        return max;
//    }
//
//    private boolean check(String substring, Map<String, Integer> map) {
//        Map<String,Integer> tmp=new HashMap<>();
//        String[] split = substring.split("");
//        for (String s : split) {
//            Integer c = tmp.getOrDefault(s, 0);
//            tmp.put(s,c+1);
//        }
//        for (String s : map.keySet()) {
//            if(tmp.getOrDefault(s,0)<map.get(s)){
//                return false;
//            }
//        }
//        return true;
//    }
}
