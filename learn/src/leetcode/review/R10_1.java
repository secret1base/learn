package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/24
 */
public class R10_1 {
    /**
     * 10. 正则表达式匹配
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * 示例 1：
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4：
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5：
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     * 提示：
     * 0 <= s.length <= 20
     * 0 <= p.length <= 30
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     */
    public static void main(String[] args) {
        boolean match = new R10_1().isMatch("aaa","ab*ac*a");
        System.out.println(match);
    }
    public boolean isMatch(String s, String p) {
        int x=s.length()+1;
        int y=p.length()+1;
        boolean[][] arr=new boolean[y][x];
        //初始化
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i==0&&j==0){
                    arr[j][i] = true;
                }else if(j>0&&p.charAt(j-1)=='*'){
                    //检查上面两位有没有true,但凡一个节点为true即为true
                    if(j>=2){
                        arr[j][i]=arr[j-1][i]||arr[j-2][i];
                    }else{
                        arr[j][i] = arr[j-1][i];
                    }
                }
            }
        }
        //接着遍历执行
        for (int row = 1; row < y; row++) {
            for (int col=1;col<x;col++){
                char c = p.charAt(row - 1);
                if(c=='*'){
                    //1、上面两个节点中有一个true即为true
                    //2、左边为true并且x=y-1||y-1=.则为true
                    if (row>=2){
                        arr[row][col]=arr[row-1][col]||arr[row-2][col];
                    }else{
                        arr[row][col]=arr[row-1][col];
                    }
                    if(!arr[row][col]){
                        if(arr[row][col-1]&&(p.charAt(row - 2) == s.charAt(col-1)||p.charAt(row-2)=='.')){
                            arr[row][col]=true;
                        }
                    }

                }else if(c=='.'){
                    //左上角为true则为ture
                    arr[row][col]=arr[row-1][col-1];
                }else{
                    //x=y且左上角为true
                    if(p.charAt(row-1)==s.charAt(col - 1)&&arr[row-1][col-1]){
                        arr[row][col]=true;
                    }
                }
            }
        }
        for (boolean[] booleans : arr) {
            System.out.println(Arrays.toString(booleans));
        }
        return arr[y-1][x-1];
    }
}
