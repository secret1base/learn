package leetcode;

import java.util.*;

/**
 * 1143.最长公共子序列
 * @author: wyj
 * @date: 2021/05/23
 */
public class A1143_LongestCommonSubsequence {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *  一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *  例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     *  两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *  示例 1：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     *  示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     *  示例 3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *  提示：
     *  1 <= text1.length, text2.length <= 1000
     *  text1 和 text2 仅由小写英文字符组成。
     */
    public static void main(String[] args) {
        //和第十题很像，复习第十题，然后做这题
//        int i = new A1143_LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace");
        int i = new A1143_LongestCommonSubsequence().longestCommonSubsequence("bdcaba","abcbda");
    }

    /**
     * 解题思路
     * 1143.xls
     * 执行用时：20 ms, 在所有 Java 提交中击败了6.65%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了47.59%的用户
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int x=text1.length()+1;
        int y=text2.length()+1;
        //默认值0
        int[][] arr=new int[y][x];
        for (int col = 1; col < x; col++) {
            for (int row=1;row<y;row++){
                //如果当前位置对应值相等x=y则，取左上角的值+1
                if(text1.charAt(col-1)==text2.charAt(row-1)){
                    arr[row][col]=arr[row-1][col-1]+1;
                }else{
                    //如果不相等，则取上一格和左边一格的最大值
                    arr[row][col]=Math.max(arr[row-1][col],arr[row][col-1]);
                }
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        return arr[y-1][x-1];
    }


}
