package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 * @author: wyj
 * @date: 2021/07/28
 */
public class A1190_InvertsTheSubstringBetweenEachPairOfParentheses {
    /**
     * 给出一个字符串 s（仅含有小写英文字母和括号）。
     *  请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     *  注意，您的结果中 不应 包含任何括号。
     *  示例 1：
     * 输入：s = "(abcd)"
     * 输出："dcba"
     *  示例 2：
     * 输入：s = "(u(love)i)"
     * 输出："iloveu"
     * 解释：先反转子字符串 "love" ，然后反转整个字符串。
     *  示例 3：
     * 输入：s = "(ed(et(oc))el)"
     * 输出："leetcode"
     * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
     *  示例 4：
     * 输入：s = "a(bcdefghijkl(mno)p)q"
     * 输出："apmnolkjihgfedcbq"
     *  提示：
     *  0 <= s.length <= 2000
     *  s 中只有小写英文字母和括号
     *  题目测试用例确保所有括号都是成对出现的
     *
     *  一次过
     *  		执行耗时:5 ms,击败了29.18% 的Java用户
     * 			内存消耗:38.5 MB,击败了8.27% 的Java用户
     */
    public String reverseParentheses(String s) {
        Deque<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c!=')'){
                path.offerLast(c);
            }else{
                Deque<Character> tmp=new LinkedList<>();
                while (!path.isEmpty()){
                    Character character = path.pollLast();
                    if(character=='('){
                        while (!tmp.isEmpty()){
                            //反转顺序
                            path.offerLast(tmp.pollFirst());
                        }
                        break;
                    }else{
                        tmp.offerLast(character);
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new A1190_InvertsTheSubstringBetweenEachPairOfParentheses().reverseParentheses("(u(love)i)");
        System.out.println(s);
    }
}
