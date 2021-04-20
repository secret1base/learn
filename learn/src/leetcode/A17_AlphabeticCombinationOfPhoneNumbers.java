package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * @author: wyj
 * @date: 2021/04/19
 */
public class A17_AlphabeticCombinationOfPhoneNumbers {
    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 17.png
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     */
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    /**
     * 难点主要在遍历方式上，考虑采用递归实现
     * 执行用时：5 ms, 在所有 Java 提交中击败了24.84%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了21.58%的用户
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        //-----录入键盘对应值部分---
        Map<String,List<String>> map=new HashMap<>();
        String s="abcdefghijklmnopqrstuvwxyz";
        int a=2;
        int begin=0;
        int end=3;
        while (a<10){
            String str=s.substring(begin,end);
            String[] split = str.split("");
            List<String> list=new ArrayList<> ();
            for (String s1 : split) {
                list.add(s1);
            }
            map.put(Integer.toString(a),list);
            a++;
            if(a==7||a==9){
                begin=end;
                end+=4;
            }else{
                begin=end;
                end+=3;
            }
        }
        //-----录入键盘对应值部分---
        String[] split = digits.split("");
        //abc  def
        for (String s1 : split) {
            result = doForList(s1, result, map);
        }
        return result;
    }

    private static List<String> doForList(String s1,List<String> targetList, Map<String, List<String>> map) {
        List<String> resultList=new ArrayList<>();
        List<String> list = map.get(s1);
        if(targetList.size() == 0){
            for (String s : list) {
                resultList.add(s);
            }
            return resultList;
        }
        for (String t : list) {
            for (String s : targetList) {
                resultList.add(s+t);
            }
        }
        return resultList;
    }
}
