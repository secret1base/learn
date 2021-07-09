//package leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 139. 单词拆分
// * @author: wyj
// * @date: 2021/07/08
// */
//public class Fail139_WordSplitting {
//    /**
//     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//     *  说明：
//     *  拆分时可以重复使用字典中的单词。
//     *  你可以假设字典中没有重复的单词。
//     *  示例 1：
//     *  输入: s = "leetcode", wordDict = ["leet", "code"]
//     * 输出: true
//     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//     *  示例 2：
//     *  输入: s = "applepenapple", wordDict = ["apple", "pen"]
//     * 输出: true
//     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     *      注意你可以重复使用字典中的单词。
//     *  示例 3：
//     *  输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//     * 输出: false
//     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//
//    }
////    public boolean wordBreak(String s, List<String> wordDict) {
////        //看到这题的下意识想法就是对字符串s，通过wordDict进行不断的替换，
////        //当一次循环后s的长度不变时，替换结束，根据s的剩余长度返回结果
////        while (true){
////            int begin=s.length();
////            for (String s1 : wordDict) {
////                s=s.replaceAll(s1,"");
////            }
////            if(begin==s.length()){
////                break;
////            }
////        }
////        return s.length()==0;
////        /**
////         * 但是对于这个测试用例无法通过
////         * 测试用例:"cars"
////         * ["car","ca","rs"]
////         * 测试结果:false
////         * 期望结果:true
////         */
////    }
//
//    public static void main(String[] args) {
//    }
//}
