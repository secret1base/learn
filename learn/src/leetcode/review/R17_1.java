package leetcode.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/07/12
 */
public class R17_1 {
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
     * 解题难点在遍历
     * 		执行耗时:5 ms,击败了22.50% 的Java用户
     * 		内存消耗:38.7 MB,击败了14.39% 的Java用户
     */
    public List<String> letterCombinations(String digits) {
        Map<String,List<String>> map=new HashMap<>();
        int count=0;
        for(int i=2;i<=9;i++){
            int a=3;
            if(i==7||i==9){
                a=4;
            }
            List<String> list=new ArrayList<>();
            for (int k=0;k<a;k++){
                String i1 = (char)('a' + count)+"";
                list.add(i1);
                count++;
            }
            map.put(i+"",list);
        }
        List<String> total=new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String c = digits.charAt(i)+"";
            List<String> list = map.get(c);
            if(i==0){
                //初始化
                for (String s : list) {
                    total.add(s);
                }
            }else{
                List<String> tmp=new ArrayList<>();
                for (String a : total) {
                    for (String b : list) {
                        tmp.add(a+b);
                    }
                }
                total=tmp;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<String> list = new R17_1().letterCombinations("23");
        System.out.println(list);
    }
}
