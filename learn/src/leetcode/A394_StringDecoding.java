package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 394. 字符串解码
 * @author: wyj
 * @date: 2021/06/18
 */
public class A394_StringDecoding {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *  编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *  你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *  此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *  示例 1：
     *  输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     *  示例 2：
     *  输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *  示例 3：
     *  输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     *  示例 4：
     *  输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     * 			执行耗时:3 ms,击败了30.32% 的Java用户
     * 			内存消耗:38.1 MB,击败了8.35% 的Java用户
     */
    public String decodeString(String s) {
        Deque<Character> path=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c!=']'){
                path.offerLast(c);
            }else{
                String str=new String();
                String countStr="";
                boolean numFlag=false;
                while (!path.isEmpty()){
                    Character character = path.peekLast();
                    if(character!='['&!numFlag){
                        str=character+str;
                        path.pollLast();
                        continue;
                    }
                    if(character=='['){
                        numFlag=true;
                        path.pollLast();
                        continue;
                    }
                    if(numFlag){
                        if(Character.isDigit(character)){
                            countStr=character+countStr;
                            //下一格如果不是数字就退出
                            path.pollLast();
                            if(!path.isEmpty()&&!Character.isDigit(path.peekLast())){
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
                //进行处理
                int count = Integer.parseInt(countStr);
                for (int a = 0; a < count; a++) {
                    for (int b = 0; b < str.length(); b++) {
                        path.offerLast(str.charAt(b));
                    }
                }
            }
        }
        StringBuilder t=new StringBuilder();
        for (Character character : path) {
            t.append(character);
        }
        return t.toString();
    }


    /**
     * 本来想要通过正则替换的方式来实现，但是后面发现太麻烦了，就没有完全实现
     * 3[a2[c]]
     * 对应正则 \[([^\[\]]*)\]
     * 3(a2(c))
     * 对应正则\(([^()]*)\)
     *
     * List<String> list=new ArrayList<>();
     * Pattern pattern=Pattern.compile("\\[([^\\[\\]]*)\\]");
     * while (true){
     *     Matcher matcher = pattern.matcher(s);
     *     if(!matcher.find()){
     *         break;
     *     }
     *     String group = matcher.group(1);
     *     String s1 = "&" + list.size();
     *     list.add(group);
     *     StringBuffer sb=new StringBuffer();
     *     matcher.appendReplacement(sb,s1);
     *     matcher.appendTail(sb);
     *     s=sb.toString();
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = new A394_StringDecoding().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(s);
    }
}
