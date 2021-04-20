package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * @author: wyj
 * @date: 2021/04/20
 */
public class A6_ZigzagTransformation {
    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     * 输入：s = "A", numRows = 1
     * 输出："A"
     * 提示：
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     */
    public static void main(String[] args) {
//        String paypalishiring = new A6_ZigzagTransformation().convert("PAYPALISHIRING", 3);
//        String b = new A6_ZigzagTransformation().convert("PAYPALISHIRING", 4);
//        System.out.println("PAHNAPLSIIGYIR".equals(paypalishiring));
//        System.out.println("PINALSIGYAHRPI".equals(b));
        String ab = new A6_ZigzagTransformation().convert("AB", 1);
        System.out.println(ab);

    }

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了63.20%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了64.19%的用户
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        //0，1行时不进行处理
        if(numRows==1||numRows==0){
            return s;
        }
        /**
         *   0 1 2 3 4 5 6 7 8 9
         * 0 P     I     N     1
         * 1 A   L S   I G   1
         * 2 Y A   H R   1 1
         * 3 P     I     1
         * 1、找规律，当行数为0或者为n-1时，方向变更：0 down 3 up 0 down 3 up
         */
        List<StringBuilder> list=new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        boolean down=true;
        //当前行数
        int curRow=0;
        for (int i = 0; i < s.length(); i++){
            //判断当前down的状态
            //找规律，当行数为0或者为n-1时，方向变更：0 down 3 up 0 down 3 up
            if(curRow==0){
                down=true;
            }else if(curRow==numRows-1){
                down=false;
            }
            list.get(curRow).append(s.charAt(i));
            //根据方向进行行数加一或减一操作
            curRow+=down?1:-1;
        }
        StringBuilder sb=new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
