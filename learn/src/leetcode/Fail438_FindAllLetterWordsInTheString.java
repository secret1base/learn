//package leetcode;
//
//import java.util.*;
//
///**
// * 438. 找到字符串中所有字母异位词
// * @author: wyj
// * @date: 2021/07/27
// */
//public class Fail438_FindAllLetterWordsInTheString {
//    /**
//     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//     *  异位词 指字母相同，但排列不同的字符串。
//     *  示例 1:
//     * 输入: s = "cbaebabacd", p = "abc"
//     * 输出: [0,6]
//     * 解释:
//     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//     *  示例 2:
//     * 输入: s = "abab", p = "ab"
//     * 输出: [0,1,2]
//     * 解释:
//     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//     *  提示:
//     *  1 <= s.length, p.length <= 3 * 104
//     *  s 和 p 仅包含小写字母
//     */
//    /**
//     * 又又又超时了
//     */
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result=new ArrayList<>();
//        int length = p.length();
//        List<Character> list=new ArrayList<>();
//        for(int i=0;i<p.length();i++){
//            list.add(p.charAt(i));
//        }
//        Collections.sort(list);
//        Deque<Character> path=new LinkedList<>();
//        int index=0;
//        while (path.size()<length&&index<s.length()){
//            path.offerLast(s.charAt(index++));
//            if(path.size()==length){
//                List<Character> tmp = new ArrayList<>(path);
//                Collections.sort(tmp);
//                boolean success=true;
//                for (int a=0;a<length;a++){
//                    if(!tmp.get(a).equals(list.get(a))){
//                        success=false;
//                        break;
//                    }
//                }
//                if(success){
//                    result.add(index-length);
//                }
//                path.pollFirst();
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        List<Integer> anagrams = new Fail438_FindAllLetterWordsInTheString().findAnagrams("cbaebabacd", "abc");
//        System.out.println(anagrams);
//    }
//}
