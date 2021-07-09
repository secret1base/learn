package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 557. 反转字符串中的单词 III
 * @author: wyj
 * @date: 2021/06/30
 */
public class A557_InvertTheWordIIIInTheString {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *  示例：
     *  输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * 			执行耗时:5 ms,击败了84.93% 的Java用户
     * 			内存消耗:38.9 MB,击败了77.44% 的Java用户
     */
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder result=new StringBuilder();
        for (String a : arr) {
            result.append(new StringBuilder(a).reverse()).append(" ");
        }
        if(result.length()>0){
            return result.substring(0,result.length() - 1);
        }
        return "";
    }
}
