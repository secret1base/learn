package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 227. 基本计算器 II
 * @author: wyj
 * @date: 2021/06/01
 */
public class A227_BasicCalculatorII {
    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *  整数除法仅保留整数部分。
     *  示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     *  示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     *  示例 3：
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     *  提示：
     *  1 <= s.length <= 3 * 105
     *  s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     *  s 表示一个 有效表达式
     *  表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
     *  题目数据保证答案是一个 32-bit 整数
     */
    /**
     * 	执行耗时:16 ms,击败了48.20% 的Java用户
     * 	内存消耗:38.7 MB,击败了69.54% 的Java用户
     * @param s
     * @return
     */
    public int calculate(String s) {
        /**
         * 加号：将数字压入栈；
         * 减号：将数字的相反数压入栈；
         * 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果。
         */
        Stack<Integer> stack=new Stack<>();
        //优先计算乘除法
        int num=0;
        Character pre='+';
        for (int i = 0; i < s.length(); i++) {
            //每次取一个完整的数
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(!Character.isDigit(c)&&c!=' '||i+1==s.length()){
                //每次放置时看开头符号是什么
                if(pre=='+'){
                    stack.push(num);
                }else if(pre=='-'){
                    stack.push(-num);
                }else if(pre=='*'){
                    stack.push(stack.pop()*num);
                }else{
                    stack.push(stack.pop()/num);
                }
                pre=c;
                num=0;
            }
        }
        int sum=0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        int calculate = new A227_BasicCalculatorII().calculate("2+3*5/2-3");
        System.out.println(calculate);
    }
}
