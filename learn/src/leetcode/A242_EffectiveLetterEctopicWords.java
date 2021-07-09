package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * @author: wyj
 * @date: 2021/06/23
 */
public class A242_EffectiveLetterEctopicWords {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *  示例 1:
     *  输入: s = "anagram", t = "nagaram"
     * 输出: true
     *  示例 2:
     *  输入: s = "rat", t = "car"
     * 输出: false
     *  说明:
     * 你可以假设字符串只包含小写字母。
     */


    /**
     * 			执行耗时:17 ms,击败了22.89% 的Java用户
     * 			内存消耗:39.3 MB,击败了8.61% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer integer = map.get(c);
            if(integer==null){
                return false;
            }
            if(integer==0){
                return false;
            }
            if(integer==1){
                map.remove(c);
            }else{
                map.put(c, integer-1);
            }
        }
        return map.keySet().size()>0?false : true;
    }
//    /**
//     * 			执行耗时:116 ms,击败了5.10% 的Java用户
//     * 			内存消耗:48.4 MB,击败了5.15% 的Java用户
//     */
//    public boolean isAnagram(String s, String t) {
//        String[] a1 = s.split("");
//        Arrays.sort(a1);
//        String[] a2 = t.split("");
//        Arrays.sort(a2);
//        return Arrays.toString(a1).equals(Arrays.toString(a2));
//    }
}
