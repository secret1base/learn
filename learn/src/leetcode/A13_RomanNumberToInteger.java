package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * @author: wyj
 * @date: 2021/04/22
 */
public class A13_RomanNumberToInteger {
    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * 提示：
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     */
    public static void main(String[] args) {
        int mcmxciv = new A13_RomanNumberToInteger().romanToInt("MCMXCIV");
        System.out.println(mcmxciv);
    }

    /**
     * 说明:右边的数字不可能比左边的大，如果大一定是特殊情况
     * 执行用时：15 ms, 在所有 Java 提交中击败了6.12%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了22.47%的用户
     */
    public int romanToInt(String s) {
        Map<String,Integer> map=new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("XL",40);
        map.put("CD",400);
        map.put("IX",9);
        map.put("XC",90);
        map.put("CM",900);
        char[] chars = s.toCharArray();
        int sum=0;
        for(int i=chars.length-1;i>=0;i--){
            //在当前节点不是头部节点时每次都需要检查下，前面一位是不是比当前位小，是的话就是特殊情况
            if(i-1>=0){
                String now = Character.toString(chars[i]);
                String pre = Character.toString(chars[i-1]);
                if(map.get(now)<=map.get(pre)){
                    sum+=map.get(now);
                }else{
                    //特殊情况
                    sum+=map.get(pre+now);
                    i--;
                }
            }else{
                String now = Character.toString(chars[i]);
                sum+=map.get(now);
            }
        }
        return sum;
    }
}
