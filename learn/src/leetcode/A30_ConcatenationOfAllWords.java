package leetcode;

import java.util.*;

/**
 * 30.串联所有单词的子串
 * @author: wyj
 * @date: 2021/04/27
 */
public class A30_ConcatenationOfAllWords {
/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *  注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *  示例 1：
 *  输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *  示例 2：
 *  输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo","bar"};
//        List<Integer> substring = new A30_ConcatenationOfAllWords().findSubstring(s, words);
//        System.out.println(substring);//0,9
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> substring = new A30_ConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(substring);//8
    }

    /**
     * 思路:
     * 1、map记录words中的单词的出现次数
     * 2、每次循环向后移动一位截取符合words总长度的字符串
     * 3、通过map的equals方法进行判断：equals方法会判断map的key和value是否一致
     * 	执行耗时:324 ms,击败了17.73% 的Java用户
     * 	内存消耗:39.2 MB,击败了43.26% 的Java用户
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        //对特殊情况直接返回
        if(s==null||words==null||words.length == 0){
            return list;
        }
        //单个长度
        int length = words[0].length();
        int allLength=length*words.length;
        //1、map记录words中的单词的出现次数
        //2、每次循环向后移动一位截取符合words总长度的字符串
        //3、通过map的equals方法进行判断：equals方法会判断map的key和value是否一致
        Map<String,Integer> map=new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        /**
         * 注意:i<s.length()-allLength+1,这是为了能够截取到所有的可能字符串
         */
        for (int i=0;i<s.length()-allLength+1;i++){
            String tmp = s.substring(i, i + allLength);
            Map<String,Integer> tMap=new HashMap<>();
            for (int j=0;j<tmp.length(); j+=length){
                //每次向后移动一个单词位
                String word = tmp.substring(j, j + length);
                tMap.put(word,tMap.getOrDefault(word,0)+1);
            }
            //比较key和value是否完全一致，一致则记录索引位置
            if(map.equals(tMap)){
                list.add(i);
            }
        }
        return list;
    }


}
