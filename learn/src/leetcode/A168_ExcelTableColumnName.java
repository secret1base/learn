package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 168. Excel表列名称
 * @author: wyj
 * @date: 2021/07/08
 */
public class A168_ExcelTableColumnName {
    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     *  例如：
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     *  示例 1：
     * 输入：columnNumber = 1
     * 输出："A"
     *  示例 2：
     * 输入：columnNumber = 28
     * 输出："AB"
     *  示例 3：
     * 输入：columnNumber = 701
     * 输出："ZY"
     *  示例 4：
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     *
     * 这题挺难的，只是答案短
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.4 MB,击败了74.67% 的Java用户
     */
    public String convertToTitle(int cn) {
        StringBuilder sb=new StringBuilder();
        while (cn>0){
            cn--;
            sb.append((char)(cn%26+'A'));
            cn/=26;
        }
        sb.reverse();
        return sb.toString();
    }

    /**
     * 一次错误的尝试，主要是没有考虑到0
     * @param args
     */
//    public String convertToTitle(int columnNumber) {
//        //701 ZY 701/26=26 701-26*26=25
//        //ZY=26*26^1+25
//        //ZZY=26*26^2+26*26^1+25*26^0
//        //这题是一个10进制转26进制的题,每26进1,并且没有0
//        Map<Integer,Character> map=new HashMap<>();
//        for (int i=1;i<27;i++){
//            map.put(i,(char)('A'-'0'+i-1+'0'));
//        }
//        char[] chars=new char[Integer.toString(columnNumber).length()];
//        while (columnNumber!=0){
//            int count=0;
//            int value=columnNumber;
//            while (value>26){
//                value/=26;
//                count++;
//            }
//            chars[chars.length-count-1]=map.get(value);
//            int minue=value;
//            for (int i = 0; i < count;i++){
//                minue*=26;
//            }
//            columnNumber-=minue;
//        }
//        StringBuilder sb=new StringBuilder();
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i]=='\u0000'&&sb.length()==0){
//                continue;
//            }
//            sb.append(chars[i]=='\u0000'?'0':chars[i]);
//        }
//        return sb.toString();
//    }
    public static void main(String[] args) {
        System.out.println(new A168_ExcelTableColumnName().convertToTitle(701));//ZY
        System.out.println(new A168_ExcelTableColumnName().convertToTitle(2147483647));//FXSHRXW
        System.out.println(new A168_ExcelTableColumnName().convertToTitle(52));//AZ

    }
}
