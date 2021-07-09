package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 171. Excel表列序号
 * @author: wyj
 * @date: 2021/07/09
 * 和168关联
 */
public class A171_ExcelColumnNumber {
    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     *  例如，
     *      A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     *  示例 1:
     *  输入: "A"
     * 输出: 1
     *  示例 2:
     *  输入: "AB"
     * 输出: 28
     *  示例 3:
     *  输入: "ZY"
     * 输出: 701
     *
     * 			执行耗时:2 ms,击败了32.97% 的Java用户
     * 			内存消耗:38.7 MB,击败了5.32% 的Java用户
     */
    public int titleToNumber(String columnTitle) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<26;i++){
            map.put((char)('A'+i),i+1);
        }
        int sum=0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            Integer a = map.get(c);
            //AB,在A的时候应该是1*26^2-1
            int temp=1;
            for (int k=0;k<columnTitle.length()-1-i;k++){
                temp*=26;
            }
            sum+=temp*a;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new A171_ExcelColumnNumber().titleToNumber("AB"));
    }
}
