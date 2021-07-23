package leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 * @author: wyj
 * @date: 2021/07/22
 */
public class A49_GroupingOfWordsWithDifferentLetters {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
     *  字母异位词指字母相同，但排列不同的字符串。
     *  示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *  示例 2:
     * 输入: strs = [""]
     * 输出: [[""]]
     *  示例 3:
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *  提示：
     *  1 <= strs.length <= 104
     *  0 <= strs[i].length <= 100
     *  strs[i] 仅包含小写字母
     *
     *  		执行耗时:1308 ms,击败了5.01% 的Java用户
     * 			内存消耗:41.2 MB,击败了80.28% 的Java用户
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //字符串的归类
        List<List<String>> list=new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            //寻找是否能够进行归类
            //归类成功标识
            boolean flag=false;
            for (int j = 0; j < list.size(); j++) {
                List<String> tmp = list.get(j);
                String s = tmp.get(0);
                if(validate(str,s)){
                    tmp.add(str);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                List<String> tmp=new ArrayList<>();
                tmp.add(str);
                list.add(tmp);
            }
        }
        return list;
    }

    private boolean validate(String str, String s) {
        if(str.length()!=s.length()){
            return false;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        for (int i = 0; i < chars1.length; i++) {
            if(chars[i]!=chars1[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> list = new A49_GroupingOfWordsWithDifferentLetters().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> strings : list) {
            System.out.println(strings);
        }
    }
}
