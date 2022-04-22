package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * @author: wyj
 * @date: 2021/07/28
 */
public class A387_FirstUniqueCharacterInAString {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *  示例：
     *  s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     *  提示：你可以假定该字符串只包含小写字母。
     *  		执行耗时:25 ms,击败了63.59% 的Java用户
     * 			内存消耗:38.9 MB,击败了68.81% 的Java用户
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            Integer integer = map.getOrDefault(c,0);
            map.put(c,integer+1);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(s.charAt(i));
            if(integer==1){
                return i;
            }
        }
        return -1;
    }
}
