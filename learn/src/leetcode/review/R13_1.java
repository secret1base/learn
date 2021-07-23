package leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/07/22
 */
public class R13_1 {
    /**
     * 			执行耗时:11 ms,击败了10.87% 的Java用户
     * 			内存消耗:39.1 MB,击败了12.78% 的Java用户
     */
    public int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int sum=0;
        for (int i=0;i<s.length();i++){
            if(i+1<s.length()){
                Integer integer = map.get(s.substring(i, i + 2));
                if(integer!=null){
                    sum += integer;
                    i++;
                    continue;
                }
            }
            Integer integer = map.get(s.charAt(i) + "");
            sum+=integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        int lviii = new R13_1().romanToInt("LVIII");
        System.out.println(lviii);
    }
}
