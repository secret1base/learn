package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R1143_3 {
//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
// 示例 1：
//输入：text1 = "abcde", text2 = "ace"
//		执行耗时:12 ms,击败了69.40% 的Java用户
//		内存消耗:42.2 MB,击败了51.58% 的Java用户
    public int longestCommonSubsequence(String text1, String text2) {
        int x=text1.length()+1;
        int y=text2.length() + 1;
        int[][] arr=new int[y][x];
        for (int row = 1; row < y; row++) {
            for (int col = 1; col < x; col++) {
                char a = text1.charAt(col - 1);
                char b = text2.charAt(row - 1);
                if(a==b){
                    arr[row][col]=arr[row-1][col-1]+1;
                }else{
                    arr[row][col]=Math.max(arr[row-1][col],arr[row][col - 1]);
                }
            }
        }
        return arr[y-1][x-1];
    }

    public static void main(String[] args) {
        int i = new R1143_3().longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
