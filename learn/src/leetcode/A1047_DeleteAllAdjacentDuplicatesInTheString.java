package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * @author: wyj
 * @date: 2021/06/24
 */
public class A1047_DeleteAllAdjacentDuplicatesInTheString {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *  在 S 上反复执行重复项删除操作，直到无法继续删除。
     *  在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *  示例：
     *  输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
     * 只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     */
    /**
     * 通过链表
     * 		执行耗时:24 ms,击败了52.20% 的Java用户
     * 		内存消耗:40 MB,击败了13.14% 的Java用户
     */
    public String removeDuplicates(String s) {
        Deque<Character> path=new LinkedList<>();
        for (int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(!path.isEmpty()&&path.peekLast()==c){
                while (!path.isEmpty()&&path.peekLast()==c){
                    path.pollLast();
                }
            }else{
                path.offerLast(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : path) {
            sb.append(character);
        }
        return sb.toString();
    }
//    /**
//     * 取巧的办法
//     * 		执行耗时:291 ms,击败了5.06% 的Java用户
//     * 		内存消耗:39.8 MB,击败了13.77% 的Java用户
//     * @param s
//     * @return
//     */
//    public String removeDuplicates(String s) {
//        String[] split = s.split("");
//        Set<String> list=new HashSet<>();
//        for (String s1 : split) {
//            list.add(s1);
//        }
//        int pre=s.length();
//        while (true){
//            for (String s1 : list) {
//                s=s.replaceAll(s1+s1,"");
//            }
//            if(s.length()==pre){
//                break;
//            }else{
//                pre=s.length();
//            }
//        }
//        return s;
//    }

    public static void main(String[] args) {
        String abbaca = new A1047_DeleteAllAdjacentDuplicatesInTheString().removeDuplicates("abbaca");
        System.out.println(abbaca);
    }
}
