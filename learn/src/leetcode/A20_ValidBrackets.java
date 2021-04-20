package leetcode;

import datastructure.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 * @author: wyj
 * @date: 2021/04/20
 */
public class A20_ValidBrackets {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     * 输入：s = "{[]}"
     * 输出：true
     * 提示：
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */
    public static void main(String[] args) {
        boolean valid = new A20_ValidBrackets().isValid("()");
        System.out.println(valid);
    }

    /**
     * 解法1：
     * 解题思路:有效括号最中间一定会有一个单独的闭合括号()/[]/{}
     * 执行用时：196 ms, 在所有 Java 提交中击败了5.20%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了5.03%的用户
     */
    public boolean isValid(String s) {
        while (s.length() > 0){
            int length = s.length();
            s=s.replaceAll("\\(\\)","").replaceAll("\\[\\]","").replaceAll("\\{\\}","");
            if(length==s.length()){
                break;
            }
        }
        return s.length()==0;
    }

//    /**
//     * 解法2：字符串中的括号必须成对出现，通过队列实现：当括号为左括号时执行放入操作，当括号为右括号时执行取出操作
//     * 如果最后队列长度不为零说明括号不是成对出现的
//     * 执行用时：13 ms, 在所有 Java 提交中击败了5.89%的用户
//     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了5.64%的用户
//     */
//    public boolean isValid(String s) {
//        Map<String,String> map=new HashMap<>();
//        map.put("{","}");
//        map.put("(",")");
//        map.put("[","]");
//        Deque<String> deque=new ArrayDeque<>();
//        String[] split = s.split("");
//        for (String s1 : split) {
//            if(s1!=null&&!s1.isEmpty()){
//                if(deque.size()==0){
//                    if(s1.equals("{")||s1.equals("[")||s1.equals("(")){
//                        deque.addLast(s1);
//                    }else{
//                        return false;
//                    }
//                }else{
//                    //判断 是否是左
//                    if(s1.equals("{")||s1.equals("[")||s1.equals("(")){
//                        deque.addLast(s1);
//                    }else{
//                        String last = deque.getLast();
//                        if(map.get(last).equals(s1)){
//                            deque.removeLast();
//                        }else{
//                            return false;
//                        }
//                    }
//                }
//            }
//
//        }
//        if(deque.size()>0){
//            return false;
//        }else{
//            return true;
//        }
//    }
}
