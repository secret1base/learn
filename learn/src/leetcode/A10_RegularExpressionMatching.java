package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/04/21
 */
public class A10_RegularExpressionMatching {
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
        boolean mississippi = new A10_RegularExpressionMatching().isMatch("mississippi", "mis*is*p*.");
        System.out.println(mississippi);
    }
    /**
     * 这题凭空思考太难了，记住规律后，根据规律实现代码就好
     * 实现规律查看文件
     * 10. 正则表达式匹配.xls
     * 下面的代码是严格根据思路来写的，为了后续便于理解没有进行优化
     * 执行用时：5 ms, 在所有 Java 提交中击败了63.03%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了21.89%的用户
     */
    public boolean isMatch(String s, String p) {
        int x = s.length()+1;
        int y = p.length()+1;
        boolean[][] arr=new boolean[x][y];
        /**
         * 0   1   1   1   1   1
         * 1   -1  -1  -1  -1  -1
         * 1   -1  -1  -1  -1  -1
         * 1   -1  -1  -1  -1  -1
         * 1   -1  -1  -1  -1  -1
         * 进行初始化，初始化为上面的情况
         */
        for (int a=0;a<x;a++){
            for (int b=0;b<y;b++){
                if(a==0&&b==0){
                    arr[a][b]=true;
                }else{
                    if(b>0){
                        if(p.charAt(b-1)=='*'){
                            //向上两个节点，只要一格节点是true当前就是true
                            if(b>1){
                                arr[a][b]=arr[a][b-1]||arr[a][b-2];
                            }else {
                                arr[a][b]=arr[a][b-1];
                            }
                        }
                    }
                }
            }
        }
        //根据规律进行判断
        for (int a=1;a<x;a++){
            for (int b=1;b<y;b++){
                char bb = p.charAt(b - 1);
                char aa = s.charAt(a - 1);
                if(bb=='*'){
                    /**
                     * 1、先判断上面两格子b-1，b-2是否存在true，存在则为true
                     * 2、如不满足上面条件，需要满足两个条件
                     *    1、判断a-1是否为true，存在则为true
                     *    2、y-1=x =>p.charAt(b-2)==s.charAt(a-1)或者y-1==.
                     */
                    boolean b1=false;
                    boolean b2=false;
                    if(b-2>=0){
                        b1=arr[a][b-2];
                    }
                    b2=arr[a][b-1];
                    if(b1||b2){
                        arr[a][b]=true;
                        continue;
                    }
                    //如果不能满足上面条件，判断a-1是否为true
                    if(arr[a-1][b]&&(p.charAt(b-2)==s.charAt(a-1)||p.charAt(b-2)=='.')){
                        arr[a][b]=true;
                    }else{
                        arr[a][b]=false;
                    }
                }else if(bb=='.'){
                    //需要满足左上角为true
                    if(arr[a-1][b-1]){
                        arr[a][b]=true;
                    }else {
                        arr[a][b]=false;
                    }
                }else{
                    //需要满足当前格相等且左上角为true
                    if(bb==aa&&arr[a-1][b-1]){
                        arr[a][b]=true;
                    }else{
                        arr[a][b]=false;
                    }
                }
            }
        }
        return arr[x-1][y-1];
    }
}
