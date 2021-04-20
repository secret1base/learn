package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * @author: wyj
 * @date: 2021/04/20
 */
public class A22_BracketGenerating {
    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     * 提示：
     * 1 <= n <= 8
     */
    public static void main(String[] args) {
        List<String> list = new A22_BracketGenerating().generateParenthesis(3);
        System.out.println(list);
    }

    /**
     * 逻辑说明图片22.jpg
     * 执行用时：2 ms, 在所有 Java 提交中击败了29.92%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了98.32%的用户
     */
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left=0;
        int right=0;
        doRun(left,right,n,"");
        return list;
    }

    private void doRun(int left, int right,int n,String s) {
        if(left==n&&right==n){
            list.add(s);
            return;
        }
        if(left>n||left<right){
            return;
        }
        doRun(left+1,right,n,s+"(");
        doRun(left,right+1,n,s+")");
    }


}
