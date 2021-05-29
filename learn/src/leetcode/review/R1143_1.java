package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R1143_1 {
    //给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
// 示例 1：
//输入：text1 = "abcde", text2 = "ace"
    public int longestCommonSubsequence(String text1, String text2) {
        int x=text1.length()+1;
        int y=text2.length()+1;
        int[][] arr=new int[y][x];
        for (int col=1;col<x;col++){
            for (int row=1;row<y;row++){
                if(text1.charAt(col-1)==text2.charAt(row-1)){
                    arr[row][col]=arr[row-1][col-1]+1;
                }else{
                    arr[row][col]=Math.max(arr[row-1][col],arr[row][col-1]);
                }
            }
        }
        return arr[y-1][x-1];
    }
}
