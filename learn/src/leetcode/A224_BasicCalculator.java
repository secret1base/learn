package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * @author: wyj
 * @date: 2021/06/18
 */
public class A224_BasicCalculator {
    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *  示例 1：
     * 输入：s = "1 + 1"
     * 输出：2
     *  示例 2：
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     *  示例 3：
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * 这道题做的调试比较多，主要通过队列来实现解题
     * 			执行耗时:21 ms,击败了24.09% 的Java用户
     * 			内存消耗:41.5 MB,击败了12.96% 的Java用户
     */
    public int calculate(String s) {
        Deque<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c!=')'&&c!=' '){
                path.offerLast(c);
            }else if(c==' '){
                continue;
            }else{
                //)
                Deque<Character> tmp=new LinkedList<>();
                //(4+5+2)
                while (!path.isEmpty()){
                    Character character = path.pollLast();
                    if(character!='('){
                        tmp.offerFirst(character);
                    }else{
                        break;
                    }
                }
                int value= calculate(tmp);
                String s1 = Integer.toString(value);
                //需要判断下，如果是带符号的需要和符号进行抵消
                for (int k=0;k<s1.length(); k++){
                    if(s1.charAt(k) =='-'&&!path.isEmpty()){
                        Character character = path.pollLast();
                        if(character=='-'){
                            path.offerLast('+');
                        }else{
                            path.offerLast('-');
                        }
                    }else{
                        path.offerLast(s1.charAt(k));
                    }

                }
            }
        }
        return calculate(path);
    }

    private int calculate(Deque<Character> tmp) {
        Deque<Integer> list=new LinkedList<>();
        Character pre='+';
        int num=0;
        while (!tmp.isEmpty()){
            Character character = tmp.pollFirst();
            if(Character.isDigit(character)){
                num=num*10+(character-'0');
            }else{
                if(pre=='+'){
                    list.offerLast(num);
                }else if(pre=='-'){
                    list.offerLast(-num);
                }else if(pre=='*'){
                    list.offerLast(list.pollLast()*num);
                }else if(pre=='/'){
                    list.offerLast(list.pollLast()/num);
                }
                pre=character;
                num=0;
            }
        }
        if(num!=0){
            if(pre=='+'){
                list.offerLast(num);
            }else if(pre=='-'){
                list.offerLast(-num);
            }else if(pre=='*'){
                list.offerLast(list.pollLast()*num);
            }else if(pre=='/'){
                list.offerLast(list.pollLast()/num);
            }
        }
        int sum=0;
        for (Integer integer : list) {
            sum+=integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        int calculate = new A224_BasicCalculator().calculate("(5-(1+(5)))");
        System.out.println(calculate);
    }
}
